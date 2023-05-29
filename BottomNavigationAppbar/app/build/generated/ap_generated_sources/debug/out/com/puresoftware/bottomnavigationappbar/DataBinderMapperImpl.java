package com.puresoftware.bottomnavigationappbar;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.puresoftware.bottomnavigationappbar.databinding.HolderRecyclerviewInBindingImpl;
import com.puresoftware.bottomnavigationappbar.databinding.HolderRecyclerviewOutBindingImpl;
import com.puresoftware.bottomnavigationappbar.databinding.MainItemViewpagerBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_HOLDERRECYCLERVIEWIN = 1;

  private static final int LAYOUT_HOLDERRECYCLERVIEWOUT = 2;

  private static final int LAYOUT_MAINITEMVIEWPAGER = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.puresoftware.bottomnavigationappbar.R.layout.holder_recyclerview_in, LAYOUT_HOLDERRECYCLERVIEWIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.puresoftware.bottomnavigationappbar.R.layout.holder_recyclerview_out, LAYOUT_HOLDERRECYCLERVIEWOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.puresoftware.bottomnavigationappbar.R.layout.main_item_viewpager, LAYOUT_MAINITEMVIEWPAGER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_HOLDERRECYCLERVIEWIN: {
          if ("layout/holder_recyclerview_in_0".equals(tag)) {
            return new HolderRecyclerviewInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for holder_recyclerview_in is invalid. Received: " + tag);
        }
        case  LAYOUT_HOLDERRECYCLERVIEWOUT: {
          if ("layout/holder_recyclerview_out_0".equals(tag)) {
            return new HolderRecyclerviewOutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for holder_recyclerview_out is invalid. Received: " + tag);
        }
        case  LAYOUT_MAINITEMVIEWPAGER: {
          if ("layout/main_item_viewpager_0".equals(tag)) {
            return new MainItemViewpagerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for main_item_viewpager is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "model");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/holder_recyclerview_in_0", com.puresoftware.bottomnavigationappbar.R.layout.holder_recyclerview_in);
      sKeys.put("layout/holder_recyclerview_out_0", com.puresoftware.bottomnavigationappbar.R.layout.holder_recyclerview_out);
      sKeys.put("layout/main_item_viewpager_0", com.puresoftware.bottomnavigationappbar.R.layout.main_item_viewpager);
    }
  }
}
