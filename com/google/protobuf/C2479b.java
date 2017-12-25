package com.google.protobuf;

import com.google.protobuf.C2488a.C2483a.C3638a;
import java.io.IOException;
import java.io.InputStream;

public abstract class C2479b<MessageType extends C2487l> implements C2478n<MessageType> {
    private static final C3645e f8820a = C3645e.m19140a();

    public /* synthetic */ Object mo1348b(C3642c c3642c) {
        return m12250a(c3642c);
    }

    public /* synthetic */ Object mo1349b(C3643d c3643d) {
        return m12252a(c3643d);
    }

    public /* synthetic */ Object mo1350b(byte[] bArr) {
        return m12255a(bArr);
    }

    public /* synthetic */ Object mo1351b(byte[] bArr, C3645e c3645e) {
        return m12257a(bArr, c3645e);
    }

    public /* synthetic */ Object mo1352c(C3642c c3642c, C3645e c3645e) {
        return m12258b(c3642c, c3645e);
    }

    public /* synthetic */ Object mo1353c(InputStream inputStream) {
        return m12259b(inputStream);
    }

    public /* synthetic */ Object mo1354d(C3643d c3643d, C3645e c3645e) {
        return m12266c(c3643d, c3645e);
    }

    public /* synthetic */ Object mo1355d(InputStream inputStream) {
        return m12253a(inputStream);
    }

    public /* synthetic */ Object mo1356e(InputStream inputStream, C3645e c3645e) {
        return m12270d(inputStream, c3645e);
    }

    public /* synthetic */ Object mo1357f(InputStream inputStream, C3645e c3645e) {
        return m12260b(inputStream, c3645e);
    }

    private UninitializedMessageException m12248a(MessageType messageType) {
        if (messageType instanceof C2488a) {
            return ((C2488a) messageType).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messageType);
    }

    private MessageType m12249b(MessageType messageType) {
        if (messageType == null || messageType.isInitialized()) {
            return messageType;
        }
        throw m12248a((C2487l) messageType).m19063a().m19061a(messageType);
    }

    public MessageType m12266c(C3643d c3643d, C3645e c3645e) {
        return m12249b((C2487l) mo1358b(c3643d, c3645e));
    }

    public MessageType m12252a(C3643d c3643d) {
        return m12266c(c3643d, f8820a);
    }

    public MessageType m12251a(C3642c c3642c, C3645e c3645e) {
        C2487l c2487l;
        try {
            C3643d h = c3642c.mo2759h();
            c2487l = (C2487l) mo1358b(h, c3645e);
            h.m19108a(0);
            return c2487l;
        } catch (InvalidProtocolBufferException e) {
            throw e.m19061a(c2487l);
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    public MessageType m12258b(C3642c c3642c, C3645e c3645e) {
        return m12249b(m12251a(c3642c, c3645e));
    }

    public MessageType m12250a(C3642c c3642c) {
        return m12258b(c3642c, f8820a);
    }

    public MessageType m12256a(byte[] bArr, int i, int i2, C3645e c3645e) {
        C2487l c2487l;
        try {
            C3643d a = C3643d.m19102a(bArr, i, i2);
            c2487l = (C2487l) mo1358b(a, c3645e);
            a.m19108a(0);
            return c2487l;
        } catch (InvalidProtocolBufferException e) {
            throw e.m19061a(c2487l);
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    public MessageType m12261b(byte[] bArr, int i, int i2, C3645e c3645e) {
        return m12249b(m12256a(bArr, i, i2, c3645e));
    }

    public MessageType m12257a(byte[] bArr, C3645e c3645e) {
        return m12261b(bArr, 0, bArr.length, c3645e);
    }

    public MessageType m12255a(byte[] bArr) {
        return m12257a(bArr, f8820a);
    }

    public MessageType m12254a(InputStream inputStream, C3645e c3645e) {
        C3643d a = C3643d.m19101a(inputStream);
        C2487l c2487l = (C2487l) mo1358b(a, c3645e);
        try {
            a.m19108a(0);
            return c2487l;
        } catch (InvalidProtocolBufferException e) {
            throw e.m19061a(c2487l);
        }
    }

    public MessageType m12260b(InputStream inputStream, C3645e c3645e) {
        return m12249b(m12254a(inputStream, c3645e));
    }

    public MessageType m12253a(InputStream inputStream) {
        return m12260b(inputStream, f8820a);
    }

    public MessageType m12267c(InputStream inputStream, C3645e c3645e) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return m12254a(new C3638a(inputStream, C3643d.m19099a(read, inputStream)), c3645e);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType m12270d(InputStream inputStream, C3645e c3645e) {
        return m12249b(m12267c(inputStream, c3645e));
    }

    public MessageType m12259b(InputStream inputStream) {
        return m12270d(inputStream, f8820a);
    }
}
