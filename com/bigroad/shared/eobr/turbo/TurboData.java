package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.C1180y;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

public abstract class TurboData {

    public enum AutoWriteTypes implements C1000c {
        AUTO_WRITE_TYPE_NONE(0),
        AUTO_WRITE_TYPE_ELAPSED_TIME(1);
        
        private final int m_id;

        private AutoWriteTypes(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == AUTO_WRITE_TYPE_NONE;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Class cls = getClass();
        stringBuffer.append(cls.getSimpleName());
        stringBuffer.append(":");
        for (Field field : cls.getFields()) {
            if (!(mo769a(field.getName()) || Modifier.isStatic(field.getModifiers()))) {
                stringBuffer.append(" ");
                stringBuffer.append(field.getName());
                stringBuffer.append("=");
                try {
                    Object obj = field.get(this);
                    try {
                        stringBuffer.append(cls.getMethod(field.getName() + "ToString", (Class[]) null).invoke(this, (Object[]) null));
                    } catch (Exception e) {
                        if (obj instanceof byte[]) {
                            byte[] bArr = (byte[]) obj;
                            if (bArr.length > 16) {
                                stringBuffer.append("len:" + bArr.length);
                            } else {
                                stringBuffer.append(C1180y.m5990a(bArr));
                            }
                        } else {
                            stringBuffer.append(obj);
                        }
                    }
                } catch (IllegalAccessException e2) {
                }
            }
        }
        for (String str : mo768k()) {
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            try {
                stringBuffer.append(cls.getMethod(str, (Class[]) null).invoke(this, (Object[]) null));
            } catch (Exception e3) {
            }
        }
        return stringBuffer.toString();
    }

    protected boolean mo769a(String str) {
        return false;
    }

    protected List<String> mo768k() {
        return Collections.emptyList();
    }

    public static C1000c m5121a(C1000c[] c1000cArr, int i) {
        C1000c c1000c = null;
        int length = c1000cArr.length;
        int i2 = 0;
        while (i2 < length) {
            C1000c c1000c2 = c1000cArr[i2];
            if (c1000c2.mo760a() == i) {
                return c1000c2;
            }
            if (!c1000c2.mo761b()) {
                c1000c2 = c1000c;
            }
            i2++;
            c1000c = c1000c2;
        }
        return c1000c;
    }
}
