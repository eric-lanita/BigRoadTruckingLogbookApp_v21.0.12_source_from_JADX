package com.google.android.gms.analytics.internal;

import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqz;

public final class zzy {
    public static zza<Long> f10384A = zza.m16727a("analytics.service_client.unexpected_reconnect_millis", 60000);
    public static zza<Long> f10385B = zza.m16727a("analytics.service_client.reconnect_throttle_millis", 1800000);
    public static zza<Long> f10386C = zza.m16727a("analytics.monitoring.sample_period_millis", 86400000);
    public static zza<Long> f10387D = zza.m16727a("analytics.initialization_warning_threshold", 5000);
    public static zza<Integer> f10388a = zza.m16725a("analytics.max_hits_per_batch", 20);
    public static zza<String> f10389b = zza.m16729a("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza<String> f10390c = zza.m16729a("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza<String> f10391d = zza.m16729a("analytics.simple_endpoint", "/collect");
    public static zza<String> f10392e = zza.m16729a("analytics.batching_endpoint", "/batch");
    public static zza<Integer> f10393f = zza.m16725a("analytics.max_get_length", 2036);
    public static zza<String> f10394g = zza.m16730a("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza<String> f10395h = zza.m16729a("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza<Integer> f10396i = zza.m16725a("analytics.max_hits_per_request.k", 20);
    public static zza<Integer> f10397j = zza.m16725a("analytics.max_hit_length.k", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<Integer> f10398k = zza.m16725a("analytics.max_post_length.k", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<Integer> f10399l = zza.m16725a("analytics.max_batch_post_length", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<String> f10400m = zza.m16729a("analytics.fallback_responses.k", "404,502");
    public static zza<Integer> f10401n = zza.m16725a("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza<Long> f10402o = zza.m16727a("analytics.service_monitor_interval", 86400000);
    public static zza<Integer> f10403p = zza.m16725a("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza<Integer> f10404q = zza.m16725a("analytics.http_connection.read_timeout_millis", 61000);
    public static zza<Long> f10405r = zza.m16727a("analytics.campaigns.time_limit", 86400000);
    public static zza<String> f10406s = zza.m16729a("analytics.first_party_experiment_id", "");
    public static zza<Integer> f10407t = zza.m16725a("analytics.first_party_experiment_variant", 0);
    public static zza<Boolean> f10408u = zza.m16731a("analytics.test.disable_receiver", false);
    public static zza<Long> f10409v = zza.m16728a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static zza<Long> f10410w = zza.m16727a("analytics.service_client.connect_timeout_millis", 5000);
    public static zza<Long> f10411z = zza.m16727a("analytics.service_client.second_connect_delay_millis", 5000);
    public static zza<Boolean> zzczl = zza.m16731a("analytics.service_enabled", false);
    public static zza<Boolean> zzczm = zza.m16731a("analytics.service_client_enabled", true);
    public static zza<String> zzczn = zza.m16730a("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza<Long> zzczo = zza.m16727a("analytics.max_tokens", 60);
    public static zza<Float> zzczp = zza.m16723a("analytics.tokens_per_sec", 0.5f);
    public static zza<Integer> zzczq = zza.m16726a("analytics.max_stored_hits", 2000, 20000);
    public static zza<Integer> zzczr = zza.m16725a("analytics.max_stored_hits_per_app", 2000);
    public static zza<Integer> zzczs = zza.m16725a("analytics.max_stored_properties_per_app", 100);
    public static zza<Long> zzczt = zza.m16728a("analytics.local_dispatch_millis", 1800000, 120000);
    public static zza<Long> zzczu = zza.m16728a("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static zza<Long> zzczv = zza.m16727a("analytics.min_local_dispatch_millis", 120000);
    public static zza<Long> zzczw = zza.m16727a("analytics.max_local_dispatch_millis", 7200000);
    public static zza<Long> zzczx = zza.m16727a("analytics.dispatch_alarm_millis", 7200000);
    public static zza<Long> zzczy = zza.m16727a("analytics.max_dispatch_alarm_millis", 32400000);
    public static zza<Integer> zzczz = zza.m16725a("analytics.max_hits_per_dispatch", 20);

    public static final class zza<V> {
        private final V f10382a;
        private final zzqz<V> f10383b;

        private zza(zzqz<V> com_google_android_gms_internal_zzqz_V, V v) {
            zzab.zzy(com_google_android_gms_internal_zzqz_V);
            this.f10383b = com_google_android_gms_internal_zzqz_V;
            this.f10382a = v;
        }

        static zza<Float> m16723a(String str, float f) {
            return m16724a(str, f, f);
        }

        static zza<Float> m16724a(String str, float f, float f2) {
            return new zza(zzqz.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> m16725a(String str, int i) {
            return m16726a(str, i, i);
        }

        static zza<Integer> m16726a(String str, int i, int i2) {
            return new zza(zzqz.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> m16727a(String str, long j) {
            return m16728a(str, j, j);
        }

        static zza<Long> m16728a(String str, long j, long j2) {
            return new zza(zzqz.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<String> m16729a(String str, String str2) {
            return m16730a(str, str2, str2);
        }

        static zza<String> m16730a(String str, String str2, String str3) {
            return new zza(zzqz.zzab(str, str3), str2);
        }

        static zza<Boolean> m16731a(String str, boolean z) {
            return m16732a(str, z, z);
        }

        static zza<Boolean> m16732a(String str, boolean z, boolean z2) {
            return new zza(zzqz.zzm(str, z2), Boolean.valueOf(z));
        }

        public V get() {
            return this.f10382a;
        }
    }
}
