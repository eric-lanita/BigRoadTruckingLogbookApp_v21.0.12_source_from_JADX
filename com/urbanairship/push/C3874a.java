package com.urbanairship.push;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.push.p033a.C3869c.C3868a;
import com.urbanairship.push.p033a.C3872d;
import com.urbanairship.push.p033a.C3872d.C3871a;
import com.urbanairship.util.C3954i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

class C3874a {
    public static Map<String, C3872d> m20081a(Context context, int i) {
        Exception e;
        try {
            return C3874a.m20082a(context, context.getResources().getXml(i));
        } catch (IOException e2) {
            e = e2;
            C3783j.m19728e("Failed to parse NotificationActionButtonGroups:" + e.getMessage());
            return new HashMap();
        } catch (XmlPullParserException e3) {
            e = e3;
            C3783j.m19728e("Failed to parse NotificationActionButtonGroups:" + e.getMessage());
            return new HashMap();
        } catch (NotFoundException e4) {
            e = e4;
            C3783j.m19728e("Failed to parse NotificationActionButtonGroups:" + e.getMessage());
            return new HashMap();
        }
    }

    private static Map<String, C3872d> m20082a(Context context, XmlResourceParser xmlResourceParser) {
        Map<String, C3872d> hashMap = new HashMap();
        C3871a c3871a = null;
        String str = null;
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            String attributeValue;
            if (eventType == 2 && "UrbanAirshipActionButtonGroup".equals(name)) {
                attributeValue = xmlResourceParser.getAttributeValue(null, ShareConstants.WEB_DIALOG_PARAM_ID);
                if (C3954i.m20512a(attributeValue)) {
                    C3783j.m19728e("UrbanAirshipActionButtonGroup missing id.");
                } else {
                    c3871a = new C3871a();
                    str = attributeValue;
                }
            } else if (!C3954i.m20512a(str)) {
                if (eventType == 2 && "UrbanAirshipActionButton".equals(name)) {
                    attributeValue = xmlResourceParser.getAttributeValue(null, ShareConstants.WEB_DIALOG_PARAM_ID);
                    if (C3954i.m20512a(attributeValue)) {
                        C3783j.m19728e("UrbanAirshipActionButton missing id.");
                    } else {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C3858k.UrbanAirshipActionButton);
                        c3871a.m20076a(new C3868a(attributeValue).m20067a(xmlResourceParser.getAttributeBooleanValue(null, "foreground", true)).m20069b(obtainStyledAttributes.getResourceId(C3858k.UrbanAirshipActionButton_android_icon, 0)).m20065a(obtainStyledAttributes.getResourceId(C3858k.UrbanAirshipActionButton_android_label, 0)).m20066a(xmlResourceParser.getAttributeValue(null, "description")).m20068a());
                        obtainStyledAttributes.recycle();
                    }
                } else if (eventType == 3 && "UrbanAirshipActionButtonGroup".equals(name)) {
                    C3872d a = c3871a.m20077a();
                    if (a.m20078a().isEmpty()) {
                        C3783j.m19728e("UrbanAirshipActionButtonGroup " + str + " missing action buttons.");
                    } else {
                        hashMap.put(str, a);
                    }
                }
            }
        }
        return hashMap;
    }
}
