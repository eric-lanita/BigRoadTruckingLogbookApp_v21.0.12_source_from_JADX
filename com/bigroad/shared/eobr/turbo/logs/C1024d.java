package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.aq;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.ContinueDrivingPromptResponse;
import com.bigroad.ttb.protocol.TTProtocol.CursorReset;
import com.bigroad.ttb.protocol.TTProtocol.DrivingModeChange;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.bigroad.ttb.protocol.TTProtocol.LegacyYardMoveStatus;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange;
import com.google.protobuf.InvalidProtocolBufferException;

public class C1024d {
    private final ExternalVarEntry f3252a;

    public C1024d(C1025e c1025e) {
        ExternalVarEntry externalVarEntry = null;
        try {
            externalVarEntry = ExternalVarEntry.parseFrom(c1025e.f3253a);
        } catch (InvalidProtocolBufferException e) {
        }
        this.f3252a = externalVarEntry;
    }

    public C1024d(byte[] bArr) {
        ExternalVarEntry externalVarEntry = null;
        try {
            externalVarEntry = ExternalVarEntry.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
        }
        this.f3252a = externalVarEntry;
    }

    public boolean m5261a() {
        return this.f3252a != null;
    }

    public boolean m5262b() {
        return this.f3252a != null && this.f3252a.hasDutyStatusChange();
    }

    public VarDutyStatusChange m5263c() {
        return m5262b() ? this.f3252a.getDutyStatusChange() : null;
    }

    public boolean m5264d() {
        return this.f3252a != null && this.f3252a.hasDrivingModeChange();
    }

    public DrivingModeChange m5265e() {
        if (!m5264d()) {
            return null;
        }
        DrivingModeChange drivingModeChange = this.f3252a.getDrivingModeChange();
        if (drivingModeChange.hasActiveDrivingMode()) {
            return drivingModeChange;
        }
        ActiveDrivingMode activeDrivingMode = ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
        if (drivingModeChange.getLegacyYardMoveStatus() == LegacyYardMoveStatus.LEGACY_DRIVER_REQUESTED_YARD_MOVE_START) {
            activeDrivingMode = ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE;
        }
        return DrivingModeChange.newBuilder(drivingModeChange).m13598a(activeDrivingMode).m13605c();
    }

    public boolean m5266f() {
        return this.f3252a != null && this.f3252a.hasCursorReset();
    }

    public CursorReset m5267g() {
        return m5266f() ? this.f3252a.getCursorReset() : null;
    }

    public boolean m5268h() {
        return this.f3252a != null && this.f3252a.hasContinueDrivingPromptResponse();
    }

    public ContinueDrivingPromptResponse m5269i() {
        return m5268h() ? this.f3252a.getContinueDrivingPromptResponse() : null;
    }

    public ExternalVarEntry m5270j() {
        return this.f3252a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExternalEventData{");
        if (m5261a()) {
            if (m5262b()) {
                stringBuilder.append("DUTY_STATUS(");
                stringBuilder.append(DutyStatus.m4383a(m5263c().getEventType()).toString());
                stringBuilder.append(")");
            } else if (m5264d()) {
                stringBuilder.append("DRIVING_MODE(");
                stringBuilder.append(m5265e().getActiveDrivingMode());
                stringBuilder.append(")");
            } else if (m5266f()) {
                stringBuilder.append("CURSOR_RESET(");
                stringBuilder.append(m5267g().getReason().toString());
                stringBuilder.append(")");
            } else if (m5268h()) {
                ContinueDrivingPromptResponse i = m5269i();
                stringBuilder.append("CONTINUE_DRIVING(");
                stringBuilder.append(i.getContinueDriving() ? "continue" : "stop");
                stringBuilder.append(" driving segment starting at ");
                stringBuilder.append(aq.m4233e(i.getDrivingStartedAt()));
                stringBuilder.append(")");
            } else {
                stringBuilder.append("UNKNOWN");
            }
            stringBuilder.append("}");
        } else {
            stringBuilder.append("INVALID}");
        }
        return stringBuilder.toString();
    }
}
