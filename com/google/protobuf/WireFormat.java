package com.google.protobuf;

public final class WireFormat {
    static final int f13203a = m19072a(1, 3);
    static final int f13204b = m19072a(1, 4);
    static final int f13205c = m19072a(2, 0);
    static final int f13206d = m19072a(3, 2);

    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(JavaType.LONG, 0),
        UINT64(JavaType.LONG, 0),
        INT32(JavaType.INT, 0),
        FIXED64(JavaType.LONG, 1),
        FIXED32(JavaType.INT, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            public boolean mo2744c() {
                return false;
            }
        },
        GROUP(JavaType.MESSAGE, 3) {
            public boolean mo2744c() {
                return false;
            }
        },
        MESSAGE(JavaType.MESSAGE, 2) {
            public boolean mo2744c() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            public boolean mo2744c() {
                return false;
            }
        },
        UINT32(JavaType.INT, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(JavaType.INT, 5),
        SFIXED64(JavaType.LONG, 1),
        SINT32(JavaType.INT, 0),
        SINT64(JavaType.LONG, 0);
        
        private final JavaType javaType;
        private final int wireType;

        private FieldType(JavaType javaType, int i) {
            this.javaType = javaType;
            this.wireType = i;
        }

        public JavaType m19064a() {
            return this.javaType;
        }

        public int m19065b() {
            return this.wireType;
        }

        public boolean mo2744c() {
            return true;
        }
    }

    public enum JavaType {
        INT(Integer.valueOf(0)),
        LONG(Long.valueOf(0)),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.valueOf(false)),
        STRING(""),
        BYTE_STRING(C3642c.f13210a),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }
    }

    static int m19071a(int i) {
        return i & 7;
    }

    public static int m19073b(int i) {
        return i >>> 3;
    }

    static int m19072a(int i, int i2) {
        return (i << 3) | i2;
    }
}
