package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.C0126a;
import android.support.v4.widget.C0544v;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0558f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class as extends C0544v implements OnClickListener {
    private final SearchManager f2156j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f2157k;
    private final SearchableInfo f2158l;
    private final Context f2159m;
    private final WeakHashMap<String, ConstantState> f2160n;
    private final int f2161o;
    private boolean f2162p = false;
    private int f2163q = 1;
    private ColorStateList f2164r;
    private int f2165s = -1;
    private int f2166t = -1;
    private int f2167u = -1;
    private int f2168v = -1;
    private int f2169w = -1;
    private int f2170x = -1;

    private static final class C0734a {
        public final TextView f2151a;
        public final TextView f2152b;
        public final ImageView f2153c;
        public final ImageView f2154d;
        public final ImageView f2155e;

        public C0734a(View view) {
            this.f2151a = (TextView) view.findViewById(16908308);
            this.f2152b = (TextView) view.findViewById(16908309);
            this.f2153c = (ImageView) view.findViewById(16908295);
            this.f2154d = (ImageView) view.findViewById(16908296);
            this.f2155e = (ImageView) view.findViewById(C0558f.edit_query);
        }
    }

    public as(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2157k = searchView;
        this.f2158l = searchableInfo;
        this.f2161o = searchView.getSuggestionCommitIconResId();
        this.f2159m = context;
        this.f2160n = weakHashMap;
    }

    public void m3718a(int i) {
        this.f2163q = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor mo376a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2157k.getVisibility() != 0 || this.f2157k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m3714a(this.f2158l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m3710d(mo375a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m3710d(mo375a());
    }

    private void m3710d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void mo377a(Cursor cursor) {
        if (this.f2162p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo377a(cursor);
            if (cursor != null) {
                this.f2165s = cursor.getColumnIndex("suggest_text_1");
                this.f2166t = cursor.getColumnIndex("suggest_text_2");
                this.f2167u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2168v = cursor.getColumnIndex("suggest_icon_1");
                this.f2169w = cursor.getColumnIndex("suggest_icon_2");
                this.f2170x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View mo394a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo394a(context, cursor, viewGroup);
        a.setTag(new C0734a(a));
        ((ImageView) a.findViewById(C0558f.edit_query)).setImageResource(this.f2161o);
        return a;
    }

    public void mo630a(View view, Context context, Cursor cursor) {
        C0734a c0734a = (C0734a) view.getTag();
        int i;
        if (this.f2170x != -1) {
            i = cursor.getInt(this.f2170x);
        } else {
            i = 0;
        }
        if (c0734a.f2151a != null) {
            m3704a(c0734a.f2151a, m3701a(cursor, this.f2165s));
        }
        if (c0734a.f2152b != null) {
            CharSequence a = m3701a(cursor, this.f2167u);
            if (a != null) {
                a = m3709b(a);
            } else {
                a = m3701a(cursor, this.f2166t);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0734a.f2151a != null) {
                    c0734a.f2151a.setSingleLine(false);
                    c0734a.f2151a.setMaxLines(2);
                }
            } else if (c0734a.f2151a != null) {
                c0734a.f2151a.setSingleLine(true);
                c0734a.f2151a.setMaxLines(1);
            }
            m3704a(c0734a.f2152b, a);
        }
        if (c0734a.f2153c != null) {
            m3703a(c0734a.f2153c, m3711e(cursor), 4);
        }
        if (c0734a.f2154d != null) {
            m3703a(c0734a.f2154d, m3712f(cursor), 8);
        }
        if (this.f2163q == 2 || (this.f2163q == 1 && (r1 & 1) != 0)) {
            c0734a.f2155e.setVisibility(0);
            c0734a.f2155e.setTag(c0734a.f2151a.getText());
            c0734a.f2155e.setOnClickListener(this);
            return;
        }
        c0734a.f2155e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2157k.m3448a((CharSequence) tag);
        }
    }

    private CharSequence m3709b(CharSequence charSequence) {
        if (this.f2164r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0553a.textColorSearchUrl, typedValue, true);
            this.f2164r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2164r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m3704a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m3711e(Cursor cursor) {
        if (this.f2168v == -1) {
            return null;
        }
        Drawable a = m3700a(cursor.getString(this.f2168v));
        return a == null ? m3713g(cursor) : a;
    }

    private Drawable m3712f(Cursor cursor) {
        if (this.f2169w == -1) {
            return null;
        }
        return m3700a(cursor.getString(this.f2169w));
    }

    private void m3703a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence mo378c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m3702a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2158l.shouldRewriteQueryFromData()) {
            a = m3702a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2158l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m3702a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo394a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0734a) a.getTag()).f2151a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m3700a(String str) {
        if (str == null || str.length() == 0 || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2159m.getPackageName() + "/" + parseInt;
            b = m3708b(str2);
            if (b != null) {
                return b;
            }
            b = C0126a.m582a(this.f2159m, parseInt);
            m3705a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m3708b(str);
            if (b != null) {
                return b;
            }
            b = m3707b(Uri.parse(str));
            m3705a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m3707b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m3716a(uri);
            }
            openInputStream = this.f2159m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m3708b(String str) {
        ConstantState constantState = (ConstantState) this.f2160n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m3705a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2160n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m3713g(Cursor cursor) {
        Drawable a = m3699a(this.f2158l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m3699a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2160n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2160n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2159m.getResources());
        } else {
            Drawable b = m3706b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2160n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m3706b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m3702a(Cursor cursor, String str) {
        return m3701a(cursor, cursor.getColumnIndex(str));
    }

    private static String m3701a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m3716a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m3714a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
