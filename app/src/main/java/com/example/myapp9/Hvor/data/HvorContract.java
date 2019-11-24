package com.example.myapp9.Hvor.data;

import android.provider.BaseColumns;

public class HvorContract {
    private HvorContract() {}
    public static final class GemDineEntry implements BaseColumns {
        public final static String TABLE_NAME = "gemdine";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PERSON_HVOR ="hvor";
        public final static String COLUMN_PERSON_BEGRAVES = "begraves";
        public static final int BEGRAVES_UNKNOWN = 0;
        public static final int BEGRAVES_BEGRAVES = 1;
        public static final int BEGRAVES_BISAETTES = 2;
    }
}
