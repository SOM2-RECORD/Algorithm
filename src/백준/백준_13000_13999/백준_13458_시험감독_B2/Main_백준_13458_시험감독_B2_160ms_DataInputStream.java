package 백준.백준_13000_13999.백준_13458_시험감독_B2;

import java.io.*;

public class Main_백준_13458_시험감독_B2_160ms_DataInputStream {

    public static void main(String[] args) throws Exception {
        initFI();

        int n = nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = nextInt();

        int b = nextInt();
        int c = nextInt();

        long result = 0;

        for (int i = 0; i < n; i++) {
            A[i] -= b;
            result++;
            if (A[i] >= 1) { //부 감독관이 필요한 경우
                if (A[i] > c) {
                    if (A[i] % c == 0) result += A[i] / c;
                    else result += (A[i] / c) + 1;
                }
                else result++;
            }
        }

        System.out.println(result);
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}