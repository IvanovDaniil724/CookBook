package suai.ivanovdaniil.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ItemPage extends WearableActivity
{
    public ImageView Icon_Item_Image, Item_Image;
    public TextView Icon_Item_Text, RecipeDescription_Item_TextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

        findViewById(R.id.ItemPage_BackButton_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ItemPage.this, MainMenu.class);
                startActivity(intent); finish();
            }
        });

        Icon_Item_Image = findViewById(R.id.Icon_Item_Image);
        Item_Image = findViewById(R.id.Item_Image);
        Icon_Item_Text = findViewById(R.id.Icon_Item_Text);
        RecipeDescription_Item_TextView = findViewById(R.id.RecipeDescription_Item_TextView);

        switch (MainMenu.Item_ID)
        {
            case 0: { CreateItemPage("Борщ", R.drawable.image_placeholder_borsch, R.string.borsch_recipe, R.drawable.borsch); break; }
            case 1: { CreateItemPage("Цезарь", R.drawable.image_placeholder_cesar, R.string.cesar_recipe, R.drawable.cesar); break; }
            case 2: { CreateItemPage("Блинчики", R.drawable.image_placeholder_blinchik, R.string.pancakes_recipe, R.drawable.blinchik); break; }
            case 3: { CreateItemPage("Мол. коктейль", R.drawable.image_placeholder_milkshake, R.string.milkshake_recipe, R.drawable.milkshake); break; }
            case 4: { CreateItemPage("Спагетти", R.drawable.image_placeholder_spagetti, R.string.spaghetti_recipe, R.drawable.spagetti); break; }
        }
    }

    public void CreateItemPage(String title, int icon_image_id, int recipe_text_id, int image_id)
    {
        Icon_Item_Image.setImageResource(icon_image_id); Item_Image.setImageResource(image_id);
        Icon_Item_Text.setText(title); RecipeDescription_Item_TextView.setText(recipe_text_id);
    }
}
