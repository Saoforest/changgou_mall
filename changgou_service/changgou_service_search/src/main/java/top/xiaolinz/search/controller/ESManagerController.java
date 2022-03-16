package top.xiaolinz.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.search.service.EsManagerService;

/**
 * @author XiaoLin
 * @date 2022/3/15 17:28
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/manager")
@Api(value = "检索服务", tags = {"检索服务"})
public class ESManagerController {
    @Autowired
    private EsManagerService esManagerService;

    @GetMapping("/create")
    @ApiOperation(value = "创建索引")
    public R create() {
        this.esManagerService.createIndex();

        return R.ok(StatusCode.OK, "索引创建成功");
    }

    @GetMapping("/importAll")
    @ApiOperation(value = "导入所有正常商品")
    public R importAll() {
        this.esManagerService.importAll();

        return R.ok(StatusCode.OK, "导入所有正常商品成功!");
    }

    @GetMapping("/importAll/{spuId}")
    @ApiOperation(value = "根据spuID导入商品")
    public R importBySpuId(@PathVariable("spuId") String spuId) {
        this.esManagerService.importBySpuId(spuId);

        return R.ok(StatusCode.OK, "导入所有正常商品成功!");
    }

    @GetMapping("/delete/{spuId}")
    @ApiOperation(value = "根据spuId删除商品")
    public R deleteBySpuId(@PathVariable("spuId") String spuId) {
        this.esManagerService.deleteBySpuId(spuId);

        return R.ok(StatusCode.OK, "商品下架成功");
    }

}
