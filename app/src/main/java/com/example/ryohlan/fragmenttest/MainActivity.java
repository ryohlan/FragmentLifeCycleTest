package com.example.ryohlan.fragmenttest;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private int stackSize = 0;
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            add();
        }

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        findViewById(R.id.replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace();
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
            }
        });

        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }

    private void addLog(String m) {
        adapter.add(m);
        listView.smoothScrollToPosition(adapter.getCount() - 1);
    }

    private void add() {
        stackSize++;
        Fragment f = new PlaceholderFragment();
        Bundle b = new Bundle();
        b.putInt("n", stackSize);
        f.setArguments(b);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, f)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    private void delete() {
        getSupportFragmentManager().popBackStack();
    }

    private void deletedFragment() {
        stackSize--;
    }

    private void replace() {
        stackSize++;
        Fragment f = new PlaceholderFragment();
        Bundle b = new Bundle();
        b.putInt("n", stackSize);
        f.setArguments(b);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private int fragmentNumber;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            fragmentNumber = getArguments().getInt("n");
            Toast.makeText(inflater.getContext(), "" + fragmentNumber, Toast.LENGTH_SHORT).show();
            TextView t = (TextView) rootView.findViewById(R.id.text);
            t.setText(getClass().getSimpleName() + " " + fragmentNumber);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
            return rootView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            fragmentNumber = getArguments().getInt("n");
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
            return super.onContextItemSelected(item);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
            return super.onCreateAnimation(transit, enter, nextAnim);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            super.onCreateOptionsMenu(menu, inflater);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onDestroyOptionsMenu() {
            super.onDestroyOptionsMenu();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onDetach() {
            super.onDetach();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
            ((MainActivity) getActivity()).deletedFragment();
        }

        @Override
        public void onHiddenChanged(boolean hidden) {
            super.onHiddenChanged(hidden);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
            super.onInflate(activity, attrs, savedInstanceState);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onOptionsMenuClosed(Menu menu) {
            super.onOptionsMenuClosed(menu);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onPause() {
            super.onPause();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onPrepareOptionsMenu(Menu menu) {
            super.onPrepareOptionsMenu(menu);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onResume() {
            super.onResume();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onStart() {
            super.onStart();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void onStop() {
            super.onStop();
            String m = getClass().getSimpleName() + Thread.currentThread().getStackTrace()[2].getMethodName() + " " + fragmentNumber;
            Log.e("", m);
            ((MainActivity) getActivity()).addLog("Fragment " + fragmentNumber + " : " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

    }
}
