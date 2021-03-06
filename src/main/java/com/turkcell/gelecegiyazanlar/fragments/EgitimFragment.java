package com.turkcell.gelecegiyazanlar.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapter;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;


/**
 * E�itim sayfas�n�n fragment �
 */
public class EgitimFragment extends Fragment {

    public SlidingTabLayoutIcon tabs;
    SharedPreferences preferences;
    android.support.v7.widget.Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    CharSequence[] titles;
    int numbOfTabs = 3;
    ImageView ust_logo;

    public EgitimFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_egitim, container, false);

        titles = new CharSequence[]{
                getString(R.string.egitim_kategori_mobil),
                getString(R.string.egitim_kategori_web),
                getString(R.string.egitim_kategori_oyun)
        };

        ust_logo = (ImageView) rootView.findViewById(R.id.logo_ust_ekran);

        //Baslang�c resmi
        ust_logo.setImageResource(R.drawable.mobil_ust_logo);

        // Ba�l�klar�,tab say�s�n� adapterda tan�mlar
        adapter = new ViewPagerAdapter(getFragmentManager(), titles, numbOfTabs);


        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Tablar�n g�r�n�m men�s�
        tabs = (SlidingTabLayoutIcon) rootView.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // tablar�n d�zenlenebilir olmas�n� sa�lar

        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.selector));

        // pager� tablara ba�lad�k.
        tabs.setViewPager(pager);

        resimDegisikligiTabDinleyici();

        return rootView;
    }

    /**
     * Resim de�i�ikli�i sa�lar..
     */
    public void resimDegisikligiTabDinleyici() {
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ust_logo.setImageResource(R.drawable.mobil_ust_logo);
                        break;
                    case 1:
                        ust_logo.setImageResource(R.drawable.web_ust_logo);
                        break;
                    case 2:
                        ust_logo.setImageResource(R.drawable.oyun_ust_logo);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
