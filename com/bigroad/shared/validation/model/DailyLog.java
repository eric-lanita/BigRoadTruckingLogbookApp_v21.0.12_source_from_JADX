package com.bigroad.shared.validation.model;

import com.bigroad.shared.validation.C0887n;
import java.util.List;

public interface DailyLog extends C0887n<Field> {

    public enum Field {
        NONE
    }

    int mo857a();

    DailyLogHeader mo858b();

    List<? extends Event> mo859c();

    List<? extends Dvir> mo860d();

    boolean mo861e();

    boolean mo862f();
}
