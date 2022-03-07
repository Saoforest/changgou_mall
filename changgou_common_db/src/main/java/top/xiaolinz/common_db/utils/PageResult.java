package top.xiaolinz.common_db.utils;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
public class PageResult<T> {

    private Long total;//总记录数
    private List<T> rows;//记录

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public PageResult(IPage<T> page){
        this.total = page.getTotal();
        this.rows = page.getRecords();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
