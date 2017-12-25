package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.LogPriority;
import java.io.IOException;

public class GenxDataSerializationException extends IOException {
    private static final long serialVersionUID = 3561705802426076116L;
    private byte[] m_bytes = null;
    private LogPriority m_priority = LogPriority.LOG_ERROR;

    public GenxDataSerializationException(String str) {
        super(str);
    }

    public GenxDataSerializationException(String str, byte[] bArr) {
        super(str);
        this.m_bytes = bArr;
    }
}
