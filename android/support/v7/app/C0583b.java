package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ag;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0484b;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0563k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.facebook.login.widget.ProfilePictureView;
import java.lang.ref.WeakReference;

class C0583b {
    private TextView f1337A;
    private TextView f1338B;
    private View f1339C;
    private ListAdapter f1340D;
    private int f1341E = -1;
    private int f1342F;
    private int f1343G;
    private int f1344H;
    private int f1345I;
    private int f1346J;
    private int f1347K;
    private int f1348L = 0;
    private Handler f1349M;
    private final OnClickListener f1350N = new C05701(this);
    private final Context f1351a;
    private final C0585k f1352b;
    private final Window f1353c;
    private CharSequence f1354d;
    private CharSequence f1355e;
    private ListView f1356f;
    private View f1357g;
    private int f1358h;
    private int f1359i;
    private int f1360j;
    private int f1361k;
    private int f1362l;
    private boolean f1363m = false;
    private Button f1364n;
    private CharSequence f1365o;
    private Message f1366p;
    private Button f1367q;
    private CharSequence f1368r;
    private Message f1369s;
    private Button f1370t;
    private CharSequence f1371u;
    private Message f1372v;
    private NestedScrollView f1373w;
    private int f1374x = 0;
    private Drawable f1375y;
    private ImageView f1376z;

    class C05701 implements OnClickListener {
        final /* synthetic */ C0583b f1272a;

        C05701(C0583b c0583b) {
            this.f1272a = c0583b;
        }

        public void onClick(View view) {
            Message obtain;
            if (view == this.f1272a.f1364n && this.f1272a.f1366p != null) {
                obtain = Message.obtain(this.f1272a.f1366p);
            } else if (view == this.f1272a.f1367q && this.f1272a.f1369s != null) {
                obtain = Message.obtain(this.f1272a.f1369s);
            } else if (view != this.f1272a.f1370t || this.f1272a.f1372v == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.f1272a.f1372v);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f1272a.f1349M.obtainMessage(1, this.f1272a.f1352b).sendToTarget();
        }
    }

    public static class C0580a {
        public int f1297A;
        public boolean f1298B = false;
        public boolean[] f1299C;
        public boolean f1300D;
        public boolean f1301E;
        public int f1302F = -1;
        public OnMultiChoiceClickListener f1303G;
        public Cursor f1304H;
        public String f1305I;
        public String f1306J;
        public OnItemSelectedListener f1307K;
        public C0579a f1308L;
        public boolean f1309M = true;
        public final Context f1310a;
        public final LayoutInflater f1311b;
        public int f1312c = 0;
        public Drawable f1313d;
        public int f1314e = 0;
        public CharSequence f1315f;
        public View f1316g;
        public CharSequence f1317h;
        public CharSequence f1318i;
        public DialogInterface.OnClickListener f1319j;
        public CharSequence f1320k;
        public DialogInterface.OnClickListener f1321l;
        public CharSequence f1322m;
        public DialogInterface.OnClickListener f1323n;
        public boolean f1324o;
        public OnCancelListener f1325p;
        public OnDismissListener f1326q;
        public OnKeyListener f1327r;
        public CharSequence[] f1328s;
        public ListAdapter f1329t;
        public DialogInterface.OnClickListener f1330u;
        public int f1331v;
        public View f1332w;
        public int f1333x;
        public int f1334y;
        public int f1335z;

        public interface C0579a {
            void m2612a(ListView listView);
        }

        public C0580a(Context context) {
            this.f1310a = context;
            this.f1324o = true;
            this.f1311b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void m2614a(C0583b c0583b) {
            if (this.f1316g != null) {
                c0583b.m2652b(this.f1316g);
            } else {
                if (this.f1315f != null) {
                    c0583b.m2648a(this.f1315f);
                }
                if (this.f1313d != null) {
                    c0583b.m2646a(this.f1313d);
                }
                if (this.f1312c != 0) {
                    c0583b.m2651b(this.f1312c);
                }
                if (this.f1314e != 0) {
                    c0583b.m2651b(c0583b.m2655c(this.f1314e));
                }
            }
            if (this.f1317h != null) {
                c0583b.m2653b(this.f1317h);
            }
            if (this.f1318i != null) {
                c0583b.m2645a(-1, this.f1318i, this.f1319j, null);
            }
            if (this.f1320k != null) {
                c0583b.m2645a(-2, this.f1320k, this.f1321l, null);
            }
            if (this.f1322m != null) {
                c0583b.m2645a(-3, this.f1322m, this.f1323n, null);
            }
            if (!(this.f1328s == null && this.f1304H == null && this.f1329t == null)) {
                m2613b(c0583b);
            }
            if (this.f1332w != null) {
                if (this.f1298B) {
                    c0583b.m2647a(this.f1332w, this.f1333x, this.f1334y, this.f1335z, this.f1297A);
                    return;
                }
                c0583b.m2656c(this.f1332w);
            } else if (this.f1331v != 0) {
                c0583b.m2644a(this.f1331v);
            }
        }

        private void m2613b(final C0583b c0583b) {
            ListAdapter simpleCursorAdapter;
            final ListView listView = (ListView) this.f1311b.inflate(c0583b.f1344H, null);
            if (!this.f1300D) {
                int m;
                if (this.f1301E) {
                    m = c0583b.f1346J;
                } else {
                    m = c0583b.f1347K;
                }
                if (this.f1304H != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(this.f1310a, m, this.f1304H, new String[]{this.f1305I}, new int[]{16908308});
                } else if (this.f1329t != null) {
                    simpleCursorAdapter = this.f1329t;
                } else {
                    simpleCursorAdapter = new C0582c(this.f1310a, m, 16908308, this.f1328s);
                }
            } else if (this.f1304H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.f1310a, c0583b.f1345I, 16908308, this.f1328s) {
                    final /* synthetic */ C0580a f1286b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.f1286b.f1299C != null && this.f1286b.f1299C[i]) {
                            listView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final C0583b c0583b2 = c0583b;
                Object c05762 = new CursorAdapter(this, this.f1310a, this.f1304H, false) {
                    final /* synthetic */ C0580a f1289c;
                    private final int f1290d;
                    private final int f1291e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1290d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1291e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.f1289c.f1311b.inflate(c0583b2.f1345I, viewGroup, false);
                    }
                };
            }
            if (this.f1308L != null) {
                this.f1308L.m2612a(listView);
            }
            c0583b.f1340D = simpleCursorAdapter;
            c0583b.f1341E = this.f1302F;
            if (this.f1330u != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0580a f1293b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f1293b.f1330u.onClick(c0583b.f1352b, i);
                        if (!this.f1293b.f1301E) {
                            c0583b.f1352b.dismiss();
                        }
                    }
                });
            } else if (this.f1303G != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0580a f1296c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.f1296c.f1299C != null) {
                            this.f1296c.f1299C[i] = listView.isItemChecked(i);
                        }
                        this.f1296c.f1303G.onClick(c0583b.f1352b, i, listView.isItemChecked(i));
                    }
                });
            }
            if (this.f1307K != null) {
                listView.setOnItemSelectedListener(this.f1307K);
            }
            if (this.f1301E) {
                listView.setChoiceMode(1);
            } else if (this.f1300D) {
                listView.setChoiceMode(2);
            }
            c0583b.f1356f = listView;
        }
    }

    private static final class C0581b extends Handler {
        private WeakReference<DialogInterface> f1336a;

        public C0581b(DialogInterface dialogInterface) {
            this.f1336a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProfilePictureView.NORMAL /*-3*/:
                case ProfilePictureView.SMALL /*-2*/:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1336a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class C0582c extends ArrayAdapter<CharSequence> {
        public C0582c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    public C0583b(Context context, C0585k c0585k, Window window) {
        this.f1351a = context;
        this.f1352b = c0585k;
        this.f1353c = window;
        this.f1349M = new C0581b(c0585k);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0563k.AlertDialog, C0553a.alertDialogStyle, 0);
        this.f1342F = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_android_layout, 0);
        this.f1343G = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_buttonPanelSideLayout, 0);
        this.f1344H = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_listLayout, 0);
        this.f1345I = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_multiChoiceItemLayout, 0);
        this.f1346J = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_singleChoiceItemLayout, 0);
        this.f1347K = obtainStyledAttributes.getResourceId(C0563k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        c0585k.m2686c(1);
    }

    static boolean m2623a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0583b.m2623a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void m2643a() {
        this.f1352b.setContentView(m2627c());
        m2631d();
    }

    private int m2627c() {
        if (this.f1343G == 0) {
            return this.f1342F;
        }
        if (this.f1348L == 1) {
            return this.f1343G;
        }
        return this.f1342F;
    }

    public void m2648a(CharSequence charSequence) {
        this.f1354d = charSequence;
        if (this.f1337A != null) {
            this.f1337A.setText(charSequence);
        }
    }

    public void m2652b(View view) {
        this.f1339C = view;
    }

    public void m2653b(CharSequence charSequence) {
        this.f1355e = charSequence;
        if (this.f1338B != null) {
            this.f1338B.setText(charSequence);
        }
    }

    public void m2644a(int i) {
        this.f1357g = null;
        this.f1358h = i;
        this.f1363m = false;
    }

    public void m2656c(View view) {
        this.f1357g = view;
        this.f1358h = 0;
        this.f1363m = false;
    }

    public void m2647a(View view, int i, int i2, int i3, int i4) {
        this.f1357g = view;
        this.f1358h = 0;
        this.f1363m = true;
        this.f1359i = i;
        this.f1360j = i2;
        this.f1361k = i3;
        this.f1362l = i4;
    }

    public void m2645a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1349M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case ProfilePictureView.NORMAL /*-3*/:
                this.f1371u = charSequence;
                this.f1372v = message;
                return;
            case ProfilePictureView.SMALL /*-2*/:
                this.f1368r = charSequence;
                this.f1369s = message;
                return;
            case -1:
                this.f1365o = charSequence;
                this.f1366p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m2651b(int i) {
        this.f1375y = null;
        this.f1374x = i;
        if (this.f1376z == null) {
            return;
        }
        if (i != 0) {
            this.f1376z.setVisibility(0);
            this.f1376z.setImageResource(this.f1374x);
            return;
        }
        this.f1376z.setVisibility(8);
    }

    public void m2646a(Drawable drawable) {
        this.f1375y = drawable;
        this.f1374x = 0;
        if (this.f1376z == null) {
            return;
        }
        if (drawable != null) {
            this.f1376z.setVisibility(0);
            this.f1376z.setImageDrawable(drawable);
            return;
        }
        this.f1376z.setVisibility(8);
    }

    public int m2655c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1351a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView m2650b() {
        return this.f1356f;
    }

    public Button m2657d(int i) {
        switch (i) {
            case ProfilePictureView.NORMAL /*-3*/:
                return this.f1370t;
            case ProfilePictureView.SMALL /*-2*/:
                return this.f1367q;
            case -1:
                return this.f1364n;
            default:
                return null;
        }
    }

    public boolean m2649a(int i, KeyEvent keyEvent) {
        return this.f1373w != null && this.f1373w.m2199a(keyEvent);
    }

    public boolean m2654b(int i, KeyEvent keyEvent) {
        return this.f1373w != null && this.f1373w.m2199a(keyEvent);
    }

    private ViewGroup m2616a(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    private void m2631d() {
        boolean z;
        boolean z2;
        View findViewById = this.f1353c.findViewById(C0558f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0558f.topPanel);
        View findViewById3 = findViewById.findViewById(C0558f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0558f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0558f.customPanel);
        m2621a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0558f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0558f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0558f.buttonPanel);
        ViewGroup a = m2616a(findViewById5, findViewById2);
        ViewGroup a2 = m2616a(findViewById6, findViewById3);
        ViewGroup a3 = m2616a(findViewById7, findViewById4);
        m2629c(a2);
        m2632d(a3);
        m2626b(a);
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        if (a == null || a.getVisibility() == 8) {
            z = false;
        } else {
            z = true;
        }
        if (a3 == null || a3.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || a2 == null)) {
            findViewById3 = a2.findViewById(C0558f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z && this.f1373w != null) {
            this.f1373w.setClipToPadding(true);
        }
        if (!z3) {
            findViewById3 = this.f1356f != null ? this.f1356f : this.f1373w;
            if (findViewById3 != null) {
                int i;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m2622a(a2, findViewById3, (z2 ? 2 : 0) | i, 3);
            }
        }
        ListView listView = this.f1356f;
        if (listView != null && this.f1340D != null) {
            listView.setAdapter(this.f1340D);
            int i2 = this.f1341E;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    private void m2622a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1353c.findViewById(C0558f.scrollIndicatorUp);
        View findViewById2 = this.f1353c.findViewById(C0558f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ag.m1781a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1355e != null) {
                this.f1373w.setOnScrollChangeListener(new C0484b(this) {
                    final /* synthetic */ C0583b f1275c;

                    public void mo424a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        C0583b.m2625b(nestedScrollView, findViewById, view2);
                    }
                });
                this.f1373w.post(new Runnable(this) {
                    final /* synthetic */ C0583b f1278c;

                    public void run() {
                        C0583b.m2625b(this.f1278c.f1373w, findViewById, view2);
                    }
                });
            } else if (this.f1356f != null) {
                this.f1356f.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ C0583b f1281c;

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        C0583b.m2625b(absListView, findViewById, view2);
                    }
                });
                this.f1356f.post(new Runnable(this) {
                    final /* synthetic */ C0583b f1284c;

                    public void run() {
                        C0583b.m2625b(this.f1284c.f1356f, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void m2621a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f1357g != null) {
            view = this.f1357g;
        } else if (this.f1358h != 0) {
            view = LayoutInflater.from(this.f1351a).inflate(this.f1358h, viewGroup, false);
        } else {
            view = null;
        }
        if (view != null) {
            z = true;
        }
        if (!(z && C0583b.m2623a(view))) {
            this.f1353c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1353c.findViewById(C0558f.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.f1363m) {
                frameLayout.setPadding(this.f1359i, this.f1360j, this.f1361k, this.f1362l);
            }
            if (this.f1356f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m2626b(ViewGroup viewGroup) {
        if (this.f1339C != null) {
            viewGroup.addView(this.f1339C, 0, new LayoutParams(-1, -2));
            this.f1353c.findViewById(C0558f.title_template).setVisibility(8);
            return;
        }
        this.f1376z = (ImageView) this.f1353c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1354d) ? 1 : 0) != 0) {
            this.f1337A = (TextView) this.f1353c.findViewById(C0558f.alertTitle);
            this.f1337A.setText(this.f1354d);
            if (this.f1374x != 0) {
                this.f1376z.setImageResource(this.f1374x);
                return;
            } else if (this.f1375y != null) {
                this.f1376z.setImageDrawable(this.f1375y);
                return;
            } else {
                this.f1337A.setPadding(this.f1376z.getPaddingLeft(), this.f1376z.getPaddingTop(), this.f1376z.getPaddingRight(), this.f1376z.getPaddingBottom());
                this.f1376z.setVisibility(8);
                return;
            }
        }
        this.f1353c.findViewById(C0558f.title_template).setVisibility(8);
        this.f1376z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m2629c(ViewGroup viewGroup) {
        this.f1373w = (NestedScrollView) this.f1353c.findViewById(C0558f.scrollView);
        this.f1373w.setFocusable(false);
        this.f1373w.setNestedScrollingEnabled(false);
        this.f1338B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1338B != null) {
            if (this.f1355e != null) {
                this.f1338B.setText(this.f1355e);
                return;
            }
            this.f1338B.setVisibility(8);
            this.f1373w.removeView(this.f1338B);
            if (this.f1356f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1373w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1373w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1356f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private static void m2625b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ag.m1796b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ag.m1796b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m2632d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1364n = (Button) viewGroup.findViewById(16908313);
        this.f1364n.setOnClickListener(this.f1350N);
        if (TextUtils.isEmpty(this.f1365o)) {
            this.f1364n.setVisibility(8);
            i = 0;
        } else {
            this.f1364n.setText(this.f1365o);
            this.f1364n.setVisibility(0);
            i = 1;
        }
        this.f1367q = (Button) viewGroup.findViewById(16908314);
        this.f1367q.setOnClickListener(this.f1350N);
        if (TextUtils.isEmpty(this.f1368r)) {
            this.f1367q.setVisibility(8);
        } else {
            this.f1367q.setText(this.f1368r);
            this.f1367q.setVisibility(0);
            i |= 2;
        }
        this.f1370t = (Button) viewGroup.findViewById(16908315);
        this.f1370t.setOnClickListener(this.f1350N);
        if (TextUtils.isEmpty(this.f1371u)) {
            this.f1370t.setVisibility(8);
        } else {
            this.f1370t.setText(this.f1371u);
            this.f1370t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }
}
