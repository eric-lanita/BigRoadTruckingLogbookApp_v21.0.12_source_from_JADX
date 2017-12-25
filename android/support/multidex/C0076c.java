package android.support.multidex;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class C0076c {

    static class C0075a {
        long f406a;
        long f407b;

        C0075a() {
        }
    }

    static long m397a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C0076c.m398a(randomAccessFile, C0076c.m399a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static C0075a m399a(RandomAccessFile randomAccessFile) {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C0075a c0075a = new C0075a();
                c0075a.f407b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c0075a.f406a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c0075a;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long m398a(RandomAccessFile randomAccessFile, C0075a c0075a) {
        CRC32 crc32 = new CRC32();
        long j = c0075a.f407b;
        randomAccessFile.seek(c0075a.f406a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
