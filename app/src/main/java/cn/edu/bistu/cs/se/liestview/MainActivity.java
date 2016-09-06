package cn.edu.bistu.cs.se.liestview;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuInflater;
        import android.view.SubMenu;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ArrayAdapter;
        import android.widget.CheckBox;
        import android.widget.ListView;
        import android.widget.RadioButton;
        import android.widget.SimpleAdapter;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class MainActivity extends Activity {
    private final static String NAME="name";
    private final static String SEX="sex";
    private final static String ID="id";
    private final static String NUMBER="number";
    private final static String CLASS="class";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names={"李*","张*","崔*","王*"};
        String[] sex={"女","男","男","女"};
        String[] ids={"001", "002", "003", "004"};
        String[] numbers={"10000","10001","10002","10003"};
        String[] classes={"1605","1603","1601","1601"};

        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();

        for(int i=0;i<names.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put(NAME, names[i]);
            item.put(SEX, sex[i]);
            item.put(ID, ids[i]);
            item.put(NUMBER, numbers[i]);
            item.put(CLASS, classes[i]);
            items.add(item);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.item,new String[]{NAME,SEX,ID,NUMBER,CLASS},
                new int[]{R.id.txtName,R.id.txtSex,R.id.txtId,R.id.txtNumber,R.id.txtClass});

        ListView list=(ListView)findViewById(R.id.list);

        list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}