package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.puresoftware.bottomnavigationappbar.DataBinderMapperImpl());
  }
}
