package com.puresoftware.bottomnavigationappbar.databinding;
import com.puresoftware.bottomnavigationappbar.R;
import com.puresoftware.bottomnavigationappbar.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HolderRecyclerviewInBindingImpl extends HolderRecyclerviewInBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_brands_item, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HolderRecyclerviewInBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private HolderRecyclerviewInBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvBrandsCompany.setTag(null);
        this.tvBrandsDiscount.setTag(null);
        this.tvBrandsPrice.setTag(null);
        this.tvBrandsTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.puresoftware.bottomnavigationappbar.brands.RecyclerInViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.puresoftware.bottomnavigationappbar.brands.RecyclerInViewModel Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.puresoftware.bottomnavigationappbar.brands.RecyclerInViewModel model = mModel;
        java.lang.String modelContent = null;
        java.lang.String modelPrice = null;
        java.lang.String modelCompany = null;
        java.lang.String modelDiscount = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.content
                    modelContent = model.getContent();
                    // read model.price
                    modelPrice = model.getPrice();
                    // read model.company
                    modelCompany = model.getCompany();
                    // read model.discount
                    modelDiscount = model.getDiscount();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBrandsCompany, modelCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBrandsDiscount, modelDiscount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBrandsPrice, modelPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBrandsTitle, modelContent);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}