package com.google.android.gms.measurement.internal;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqz;

public final class zzl {
    public static zza<Boolean> aiL = zza.m17883a("measurement.service_enabled", true);
    public static zza<Boolean> aiM = zza.m17883a("measurement.service_client_enabled", true);
    public static zza<String> aiN = zza.m17882a("measurement.log_tag", "FA", "FA-SVC");
    public static zza<Long> aiO = zza.m17879a("measurement.ad_id_cache_time", 10000);
    public static zza<Long> aiP = zza.m17879a("measurement.monitoring.sample_period_millis", 86400000);
    public static zza<Long> aiQ = zza.m17880a("measurement.config.cache_time", 86400000, 3600000);
    public static zza<String> aiR = zza.m17881a("measurement.config.url_scheme", "https");
    public static zza<String> aiS = zza.m17881a("measurement.config.url_authority", "app-measurement.com");
    public static zza<Integer> aiT = zza.m17877a("measurement.upload.max_bundles", 100);
    public static zza<Integer> aiU = zza.m17877a("measurement.upload.max_batch_size", (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    public static zza<Integer> aiV = zza.m17877a("measurement.upload.max_bundle_size", (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    public static zza<Integer> aiW = zza.m17877a("measurement.upload.max_events_per_bundle", 1000);
    public static zza<Integer> aiX = zza.m17877a("measurement.upload.max_events_per_day", 100000);
    public static zza<Integer> aiY = zza.m17877a("measurement.upload.max_public_events_per_day", 50000);
    public static zza<Integer> aiZ = zza.m17877a("measurement.upload.max_conversions_per_day", 500);
    public static zza<Integer> aja = zza.m17877a("measurement.store.max_stored_events_per_app", 100000);
    public static zza<String> ajb = zza.m17881a("measurement.upload.url", "https://app-measurement.com/a");
    public static zza<Long> ajc = zza.m17879a("measurement.upload.backoff_period", 43200000);
    public static zza<Long> ajd = zza.m17879a("measurement.upload.window_interval", 3600000);
    public static zza<Long> aje = zza.m17879a("measurement.upload.interval", 3600000);
    public static zza<Long> ajf = zza.m17879a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static zza<Long> ajg = zza.m17879a("measurement.upload.initial_upload_delay_time", 15000);
    public static zza<Long> ajh = zza.m17879a("measurement.upload.retry_time", 1800000);
    public static zza<Integer> aji = zza.m17877a("measurement.upload.retry_count", 6);
    public static zza<Long> ajj = zza.m17879a("measurement.upload.max_queue_time", 2419200000L);
    public static zza<Integer> ajk = zza.m17877a("measurement.lifetimevalue.max_currency_tracked", 4);
    public static zza<Long> ajl = zza.m17879a("measurement.service_client.idle_disconnect_millis", 5000);

    public static final class zza<V> {
        private final V f12272a;
        private final zzqz<V> f12273b;
        private final String f12274c;

        private zza(String str, zzqz<V> com_google_android_gms_internal_zzqz_V, V v) {
            zzab.zzy(com_google_android_gms_internal_zzqz_V);
            this.f12273b = com_google_android_gms_internal_zzqz_V;
            this.f12272a = v;
            this.f12274c = str;
        }

        static zza<Integer> m17877a(String str, int i) {
            return m17878a(str, i, i);
        }

        static zza<Integer> m17878a(String str, int i, int i2) {
            return new zza(str, zzqz.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> m17879a(String str, long j) {
            return m17880a(str, j, j);
        }

        static zza<Long> m17880a(String str, long j, long j2) {
            return new zza(str, zzqz.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<String> m17881a(String str, String str2) {
            return m17882a(str, str2, str2);
        }

        static zza<String> m17882a(String str, String str2, String str3) {
            return new zza(str, zzqz.zzab(str, str3), str2);
        }

        static zza<Boolean> m17883a(String str, boolean z) {
            return m17884a(str, z, z);
        }

        static zza<Boolean> m17884a(String str, boolean z, boolean z2) {
            return new zza(str, zzqz.zzm(str, z2), Boolean.valueOf(z));
        }

        public V get() {
            return this.f12272a;
        }

        public V get(V v) {
            return v != null ? v : this.f12272a;
        }

        public String getKey() {
            return this.f12274c;
        }
    }
}
