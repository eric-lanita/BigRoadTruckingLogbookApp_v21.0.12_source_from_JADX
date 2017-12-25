package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p032e.C1851a;
import com.bigroad.ttb.android.util.C2280c;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OurGallery extends Fragment {
    private static final String f7218a = (OurGallery.class.getName() + ".imageList");
    private Gallery f7219b;
    private C2063a f7220c;
    private final ArrayList<File> f7221d = new ArrayList();
    private int f7222e = 0;
    private final OnClickListener f7223f = new C20601(this);
    private final OnClickListener f7224g = new C20612(this);

    class C20601 implements OnClickListener {
        final /* synthetic */ OurGallery f7214a;

        C20601(OurGallery ourGallery) {
            this.f7214a = ourGallery;
        }

        public void onClick(View view) {
            this.f7214a.m10377b();
        }
    }

    class C20612 implements OnClickListener {
        final /* synthetic */ OurGallery f7215a;

        C20612(OurGallery ourGallery) {
            this.f7215a = ourGallery;
        }

        public void onClick(View view) {
            this.f7215a.m10380c();
        }
    }

    class C20623 implements OnItemClickListener {
        final /* synthetic */ OurGallery f7216a;

        C20623(OurGallery ourGallery) {
            this.f7216a = ourGallery;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            view.showContextMenu();
        }
    }

    private class C2063a extends BaseAdapter {
        final /* synthetic */ OurGallery f7217a;

        private C2063a(OurGallery ourGallery) {
            this.f7217a = ourGallery;
        }

        public int getCount() {
            return this.f7217a.f7221d.size();
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            float f = this.f7217a.getResources().getDisplayMetrics().density;
            Display defaultDisplay = this.f7217a.getActivity().getWindowManager().getDefaultDisplay();
            int max = Math.max((int) (f * 200.0f), Math.min(defaultDisplay.getWidth(), defaultDisplay.getHeight()) / 2);
            if (view instanceof ImageView) {
                view = (ImageView) view;
            } else {
                view = new ImageView(this.f7217a.getActivity());
                view.setScaleType(ScaleType.CENTER_INSIDE);
                view.setBackgroundResource(this.f7217a.f7222e);
                view.setAdjustViewBounds(true);
            }
            Bitmap a = C2280c.m11192a((File) this.f7217a.f7221d.get(i), max, max);
            view.setLayoutParams(new LayoutParams(-2, max));
            view.setImageBitmap(a);
            return view;
        }
    }

    public static List<byte[]> m10375a(OurActivity ourActivity, int i) {
        OurGallery ourGallery = (OurGallery) ourActivity.getSupportFragmentManager().mo148a(i);
        if (ourGallery != null) {
            return ourGallery.m10383a();
        }
        C2134e.m10682e("TT-OurGallery", "Unable to get file hashes from OurGallery fragment");
        return Collections.emptyList();
    }

    protected ArrayList<byte[]> m10383a() {
        C1851a j = OurApplication.m6288j();
        ArrayList<byte[]> arrayList = new ArrayList(this.f7221d.size());
        Iterator it = this.f7221d.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            Object a = j.m8936a(file, "image/jpeg");
            if (a == null) {
                C2134e.m10682e("TT-OurGallery", "Could not enqueue " + file + " for upload");
            } else {
                arrayList.add(a);
            }
        }
        this.f7221d.clear();
        return arrayList;
    }

    private void m10377b() {
        C1632a.m7958a((Fragment) this);
    }

    private void m10380c() {
        C1632a.m7975b((Fragment) this);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C2475a.OurGallery);
        this.f7222e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.our_gallery, viewGroup, false);
        this.f7219b = (Gallery) inflate.findViewById(R.id.ourGallery);
        Button button = (Button) inflate.findViewById(R.id.newPhoto_cameraButton);
        if (OurApplication.an()) {
            button.setVisibility(0);
            button.setOnClickListener(this.f7223f);
        } else {
            button.setVisibility(8);
        }
        ((Button) inflate.findViewById(R.id.newPhoto_galleryButton)).setOnClickListener(this.f7224g);
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray(f7218a);
            if (stringArray != null) {
                for (String file : stringArray) {
                    this.f7221d.add(new File(file));
                }
            }
        }
        if (this.f7221d.isEmpty()) {
            this.f7219b.setVisibility(8);
        }
        this.f7220c = new C2063a();
        this.f7219b.setAdapter(this.f7220c);
        this.f7219b.setOnItemClickListener(new C20623(this));
        registerForContextMenu(this.f7219b);
        return inflate;
    }

    private String[] m10382d() {
        String[] strArr = new String[this.f7221d.size()];
        Iterator it = this.f7221d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            strArr[i] = ((File) it.next()).getAbsolutePath();
            i = i2;
        }
        return strArr;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArray(f7218a, m10382d());
    }

    public void onDestroy() {
        if (getActivity().isFinishing()) {
            Iterator it = this.f7221d.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (!file.delete()) {
                    C2134e.m10680d("TT-OurGallery", "Failed to delete image: '" + file.getAbsolutePath() + "'");
                }
            }
            this.f7221d.clear();
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            Object obj = null;
            switch (i) {
                case 3:
                    CharSequence stringExtra = intent.getStringExtra("com.bigroad.ttb.fileName");
                    if (!am.m4188a(stringExtra)) {
                        obj = new File(stringExtra);
                        break;
                    }
                    break;
                case 6:
                    Uri data = intent.getData();
                    if (data != null) {
                        try {
                            obj = OurApplication.m6275a(getActivity().getContentResolver().openInputStream(data));
                            break;
                        } catch (FileNotFoundException e) {
                            C2134e.m10682e("TT-OurGallery", "Selected gallery image file not found: '" + data.toString() + "'");
                            break;
                        }
                    }
                    return;
                default:
                    C2134e.m10676b("TT-OurGallery", "Ignoring completion of activity with requestCode=" + i);
                    break;
            }
            if (obj != null) {
                C2134e.m10676b("TT-OurGallery", "New photo selected: " + obj);
                this.f7221d.add(obj);
                this.f7219b.setVisibility(0);
                this.f7220c.notifyDataSetChanged();
                this.f7219b.setSelection(this.f7221d.size() - 1);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (((AdapterContextMenuInfo) contextMenuInfo).position < this.f7221d.size()) {
            getActivity().getMenuInflater().inflate(R.menu.attachment_cmenu, contextMenu);
            contextMenu.setHeaderIcon(R.drawable.context_menu_icon);
            contextMenu.setHeaderTitle(R.string.editNote_attachment);
            return;
        }
        contextMenu.clear();
        contextMenu.close();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (adapterContextMenuInfo == null) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.menu_delete:
                if (adapterContextMenuInfo.position < this.f7221d.size()) {
                    File file = (File) this.f7221d.get(adapterContextMenuInfo.position);
                    if (!file.delete()) {
                        C2134e.m10680d("TT-OurGallery", "Failed to delete selected image: '" + file.getAbsolutePath() + "'");
                    }
                    this.f7221d.remove(adapterContextMenuInfo.position);
                    if (this.f7221d.isEmpty()) {
                        this.f7219b.setVisibility(8);
                    }
                    this.f7220c.notifyDataSetChanged();
                }
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }
}
