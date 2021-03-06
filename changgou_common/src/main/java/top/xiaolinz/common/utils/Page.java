package top.xiaolinz.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * 
 * @param <T>
 */
public class Page<T> implements Serializable {

    // 当前默认为第一页
    public static final Integer pageNum = 1;
    // 默认每页显示条件
    public static final Integer pageSize = 20;
    // 全局偏移量
    public int offsize = 2;
    // 页数（第几页）
    private long currentpage;

    // 查询数据库里面对应的数据有多少条
    private long total;// 从数据库查处的总记录数

    // 每页查5条
    private int size;

    // 下页
    private int next;

    private List<T> list;

    // 最后一页
    private int last;

    private int lpage;

    private int rpage;

    // 从哪条开始查
    private long start;

    public Page() {
        super();
    }

    /****
     * 带有偏移量设置的分页
     *
     * @param total
     * @param currentpage
     * @param pagesize
     * @param offsize
     */
    public Page(long total, int currentpage, int pagesize, int offsize) {
        this.offsize = offsize;
	    this.initPage(total, currentpage, pagesize);
    }

    /****
     *
     * @param total
     *            总记录数
     * @param currentpage
     *            当前页
     * @param pagesize
     *            每页显示多少条
     */
    public Page(long total, int currentpage, int pagesize) {
	    this.initPage(total, currentpage, pagesize);
    }

    // 判断当前页是否为空或是小于1
    public static Integer cpn(Integer pageNum) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        return pageNum;
    }

    public static void main(String[] args) {
        // 总记录数
        // 当前页
        // 每页显示多少条
        int cpage = 17;
        Page page = new Page(1001, cpage, 50, 7);
        System.out.println("开始页:" + page.getLpage() + "__当前页：" + page.getCurrentpage() + "__结束页" + page.getRpage()
            + "____总页数：" + page.getLast());
    }

    /****
     *
     * @param currentpage
     * @param total
     * @param pagesize
     */
    public void setCurrentpage(long currentpage, long total, long pagesize) {
        // 可以整除的情况下
        long pagecount = total / pagesize;

        // 如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = (int)(total % pagesize == 0 ? total / pagesize : (total / pagesize) + 1);

        // 总页数
        this.last = totalPages;

        // 判断当前页是否越界,如果越界，我们就查最后一页
        if (currentpage > totalPages) {
            this.currentpage = totalPages;
        } else {
            this.currentpage = currentpage;
        }

        // 计算start
        this.start = (this.currentpage - 1) * pagesize;
    }

    // 上一页
    public long getUpper() {
        return this.currentpage > 1 ? this.currentpage - 1 : this.currentpage;
    }

    /****
     * 初始化分页
     * 
     * @param total
     * @param currentpage
     * @param pagesize
     */
    public void initPage(long total, int currentpage, int pagesize) {
        // 总记录数
        this.total = total;
        // 每页显示多少条
        this.size = pagesize;

        // 计算当前页和数据库查询起始值以及总页数
	    this.setCurrentpage(currentpage, total, pagesize);

        // 分页计算
        int leftcount = this.offsize, // 需要向上一页执行多少次
            rightcount = this.offsize;

        // 起点页
        this.lpage = currentpage;
        // 结束页
        this.rpage = currentpage;

        // 2点判断
        this.lpage = currentpage - leftcount; // 正常情况下的起点
        this.rpage = currentpage + rightcount; // 正常情况下的终点

        // 页差=总页数和结束页的差
        int topdiv = this.last - this.rpage; // 判断是否大于最大页数

        /***
         * 起点页 1、页差<0 起点页=起点页+页差值 2、页差>=0 起点和终点判断
         */
        this.lpage = topdiv < 0 ? this.lpage + topdiv : this.lpage;

        /***
         * 结束页 1、起点页<=0 结束页=|起点页|+1 2、起点页>0 结束页
         */
        this.rpage = this.lpage <= 0 ? this.rpage + (this.lpage * -1) + 1 : this.rpage;

        /***
         * 当起点页<=0 让起点页为第一页 否则不管
         */
        this.lpage = this.lpage <= 0 ? 1 : this.lpage;

        /***
         * 如果结束页>总页数 结束页=总页数 否则不管
         */
        this.rpage = this.rpage > this.last ? this.last : this.rpage;
    }

    public long getNext() {
        return this.currentpage < this.last ? this.currentpage + 1 : this.last;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public long getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(long currentpage) {
        this.currentpage = currentpage;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getLast() {
        return this.last;
    }

    // 总共有多少页，即末页
    public void setLast(int last) {
        this.last = (int)(this.total % this.size == 0 ? this.total / this.size : (this.total / this.size) + 1);
    }

    public long getLpage() {
        return this.lpage;
    }

    public void setLpage(int lpage) {
        this.lpage = lpage;
    }

    public long getRpage() {
        return this.rpage;
    }

    public void setRpage(int rpage) {
        this.rpage = rpage;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return this.list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }
}
