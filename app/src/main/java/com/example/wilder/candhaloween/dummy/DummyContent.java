package com.example.wilder.candhaloween.dummy;

import com.example.wilder.candhaloween.BonbonModel;
import com.example.wilder.candhaloween.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }
    private static final List<BonbonModel> bonbonModel = new ArrayList<>();
    private static void addItem(BonbonModel bonbonmodel) {
        bonbonModel.add(R.string.Crocodile, null);
        bonbonModel.add(R.string.Tagada, null);
        bonbonModel.add(R.string.Marshmallow, null);
        bonbonModel.add(R.string.Dragibus, null);
        bonbonModel.add(R.string.Ourson, null);
        bonbonModel.add(R.string.Arlequin, null);
        bonbonModel.add(R.string.Oeuf_au_plat, null);
        bonbonModel.add(R.string.Schtroumpfs, null);
        bonbonModel.add(R.string.Carambar, null);
        bonbonModel.add(R.string.Cola, null);
        bonbonModel.add(R.string.Roudoudou, null);
        bonbonModel.add(R.string.Langue_pik, null);
        bonbonModel.add(R.string.Banane, null);
        bonbonModel.add(R.string.Boule_de_mammouth, null);
        bonbonModel.add(R.string.Skittles, null);
        bonbonModel.add(R.string.M_Ms, null);
        bonbonModel.add(R.string.Papillote, null);
        bonbonModel.add(R.string.Kinder_surprise, null);
        bonbonModel.add(R.string.Car_en_Sac, null);}


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
