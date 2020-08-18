package suai.ivanovdaniil.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainMenu extends WearableActivity
{
    public static int Item_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);

        LinearLayout[] Items =
                {
                        findViewById(R.id.borsch_page),
                        findViewById(R.id.cesar_page),
                        findViewById(R.id.pancakes_page),
                        findViewById(R.id.milkshake_page),
                        findViewById(R.id.spaghetti_page)
                };

        FillMainMenuItem(Items, 0, "Борщ", R.drawable.ic_borsch);
        FillMainMenuItem(Items, 1, "Цезарь", R.drawable.ic_cesar);
        FillMainMenuItem(Items, 2, "Блинчики", R.drawable.ic_blinchik);
        FillMainMenuItem(Items, 3, "Мол. коктейль", R.drawable.ic_milkshake);
        FillMainMenuItem(Items, 4, "Спагетти", R.drawable.ic_spagetti);

        findViewById(R.id.BackButton_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent); finish();
            }
        });

        for (int i = 0; i < Items.length; i++)
        {
            final int j = i;
            Items[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Item_ID = j;

                    Intent intent = new Intent(MainMenu.this, ItemPage.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void FillMainMenuItem(LinearLayout[] items, int item_id, String title, int image_id)
    {
        TextView item_title_text = items[item_id].findViewById(R.id.MainMenu_Item_Text);
        ImageView item_image = items[item_id].findViewById(R.id.MainMenu_Item_Image);

        item_title_text.setText(title); item_image.setImageResource(image_id);
    }
}
