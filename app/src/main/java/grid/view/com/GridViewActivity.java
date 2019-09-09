package grid.view.com;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private Context context = GridViewActivity.this;
    private GridView gridview;
    private ArrayList<ItemModel> itemModelArrayList = new ArrayList<ItemModel>();
    private CustomBaseAdapter customBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initView();
        initObject();
        generateItemsList();
    }

    private void initView()
    {
        gridview=findViewById(R.id.grid_view);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3)
            {
                Intent intent = new Intent(GridViewActivity.this, FullScreenActivity.class);
                intent.putExtra("text",itemModelArrayList.get(position).getText());
                intent.putExtra("image",itemModelArrayList.get(position).getImage());
                startActivity(intent);
            }
        });
    }

    private void initObject()
    {
        itemModelArrayList = new ArrayList<>();
    }

    private void generateItemsList()
    {
        itemModelArrayList.add(new ItemModel("Pic 1",R.drawable.pic_1));
        itemModelArrayList.add(new ItemModel("Pic 2",R.drawable.pic_2));
        itemModelArrayList.add(new ItemModel("Pic 3",R.drawable.pic_3));
        itemModelArrayList.add(new ItemModel("Pic 4",R.drawable.pic_4));
        itemModelArrayList.add(new ItemModel("Pic 5",R.drawable.pic_5));
        itemModelArrayList.add(new ItemModel("Pic 6",R.drawable.pic_6));
        itemModelArrayList.add(new ItemModel("Pic 7",R.drawable.pic_7));
        itemModelArrayList.add(new ItemModel("Pic 8",R.drawable.pic_8));
        itemModelArrayList.add(new ItemModel("Pic 9",R.drawable.pic_9));

        customBaseAdapter = new CustomBaseAdapter(context, itemModelArrayList);
        gridview.setAdapter(customBaseAdapter);
    }
}
