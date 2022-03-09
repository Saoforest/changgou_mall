package top.xiaolinz.file.controller;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.xiaolinz.common.exception.Assert;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.file.utils.FastDFSClient;
import top.xiaolinz.file.utils.FastDFSFile;

/**
 * @author XiaoLin
 * @date 2022/3/9 14:15
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/file")
public class FileUploadController {

	@PostMapping("/upload")
	@SneakyThrows
	public R upload(MultipartFile file){
		Assert.fileIsEmpty(file);

	//	得到文件名字
		final String filename = file.getOriginalFilename();
		if (StringUtils.isEmpty(filename)) {
			throw new BusinessException("文件名为空!",StatusCode.ERROR);
        }

	//	得到文件的扩展名
		final String fileSuffix = filename.substring(filename.lastIndexOf(".") + 1);

	//	得到文件的内容
		final byte[] fileBytes = file.getBytes();

	//	创建文件信息对象
		final FastDFSFile dfsFile = new FastDFSFile(filename, fileBytes, fileSuffix);

		final String[] res = FastDFSClient.upload(dfsFile);

		// 获取组名
		final String re = res[0];

		// 获取路径
		final String re1 = res[1];

		// 拼接完整路径
		final String url = FastDFSClient.getTrackerUrl() + res[0] + "/" + res[1];



		return R.ok(StatusCode.OK,"上传成功").put("data",url);
	}
}

