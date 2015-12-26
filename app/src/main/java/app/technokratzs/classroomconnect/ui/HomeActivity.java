package app.technokratzs.classroomconnect.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.technokratzs.classroomconnect.R;
import app.technokratzs.classroomconnect.fragments.GraphFragment;
import app.technokratzs.classroomconnect.fragments.SubjectAnalysisFragment;
import app.technokratzs.classroomconnect.navigation.NavigationDrawerFragment;

/**
 * Created by afif on 12/5/15.
 */
public class HomeActivity extends ActionBarActivity {

    private Toolbar mToolBar;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolBar = (Toolbar) findViewById(R.id.action_bar);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentNavigationDrawer);
        drawerFragment.setDrawerLayout(drawerLayout,mToolBar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void displayTab(int position){


        switch (position)
        {
            case  0 :

                mFragment = new GraphFragment();


                break;

            case 1 :
                mFragment = new SubjectAnalysisFragment();
                break;


            case 2 : break;

            case 3 : break;


        }


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,mFragment);
        ft.commit();

    }

}
