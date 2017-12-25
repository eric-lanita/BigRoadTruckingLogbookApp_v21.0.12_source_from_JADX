package com.bigroad.shared.validation.model;

import com.bigroad.shared.validation.C0887n;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.List;

public interface DailyLogHeader extends C0887n<Field> {

    public enum Field {
        NONE,
        DRIVER_NAME,
        TRUCKS,
        TRAILERS,
        CARRIER_NAME,
        CARRIER_ADDRESS,
        HOME_TERMINAL,
        SHIPMENTS,
        START_ODOMETER,
        END_ODOMETER,
        TOTAL_DISTANCE
    }

    String mo824a();

    String mo825b();

    String mo826c();

    String mo827d();

    String mo828e();

    String mo829f();

    Integer mo830g();

    OdometerUnit mo831h();

    List<DailyLogTruck> mo832i();

    List<DailyLogTruck> mo833j();

    List<DailyLogTruck> mo834k();

    List<String> mo835l();

    List<String> mo836m();

    String mo837n();

    Integer mo838o();

    Integer mo839p();

    boolean mo840q();

    boolean mo841r();

    boolean mo842s();

    boolean mo843t();
}
