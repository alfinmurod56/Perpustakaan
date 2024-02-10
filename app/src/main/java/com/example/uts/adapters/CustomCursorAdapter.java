// .:: Veno Setyoaji Wiratama ::.//
// .::        311910363       ::.//
// .::        TI.19.A.2       ::.//

package com.example.uts.adapters;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.uts.R;

public class CustomCursorAdapter extends CursorAdapter {

    private LayoutInflater ly;
    private SparseBooleanArray mSelectedItems;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags){
        super(context, c, flags);
        ly = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSelectedItems = new SparseBooleanArray();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = ly.inflate(R.layout.row_data, viewGroup, false);
        MyHolder holder = new MyHolder();

        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.ListJudul = (TextView)v.findViewById(R.id.listJudul);
        holder.ListPengarang = (TextView)v.findViewById(R.id.listPengarang);
        holder.ListPenerbit = (TextView)v.findViewById(R.id.listPenerbit);
        holder.ListGenre = (TextView)v.findViewById(R.id.listGenre);
        holder.ListStatus = (TextView)v.findViewById(R.id.listStatus);

        v.setTag(holder);
        return v;

    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder) view.getTag();

        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(DBHelper2.row_id)));
        holder.ListJudul.setText     ("Judul Buku    : " + cursor.getString(cursor.getColumnIndex(DBHelper2.row_judul)));
        holder.ListPengarang.setText ("Pengarang   : " + cursor.getString(cursor.getColumnIndex(DBHelper2.row_pengarang)));
        holder.ListPenerbit.setText  ("Penerbit       : " + cursor.getString(cursor.getColumnIndex(DBHelper2.row_penerbit)));
        holder.ListGenre.setText     ("Genre           : " + cursor.getString(cursor.getColumnIndex(DBHelper2.row_genre)));
        holder.ListStatus.setText(cursor.getString(cursor.getColumnIndex(DBHelper2.row_status)));
    }

    class MyHolder{
        TextView ListID;
        TextView ListJudul;
        TextView ListPengarang;
        TextView ListPenerbit;
        TextView ListGenre;
        TextView ListStatus;
    }
}
