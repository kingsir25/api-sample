package com.example.demo.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SearchCriteriaDTO;
import com.example.demo.service.BookService;
import com.example.demo.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "PDWF Payment Status Search API")
@RestController
@RequestMapping("/PDWorkflow/API")
public class PDWFAPIController
{

	@Resource
	BookService bookService;

	@ApiOperation(value="PDWF Payment Status Search API" ,notes="支払状況ステータス検索")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "searchCriteria" ,value="検索条件" ,required=true , dataType="SearchCriteriaDTO"),
		@ApiImplicitParam(name = "userName", value = "ユーザ名", defaultValue = ""),
		@ApiImplicitParam(name = "userRoleId", value = "ユーザロ-ルID", defaultValue = ""),
		@ApiImplicitParam(name = "sqlQuery", value = "SQL", defaultValue = ""),
		@ApiImplicitParam(name = "recordCount", value = "レコード最大件数", defaultValue = "2000")
		})
	@ApiResponses({
		@ApiResponse(code=200  ,response=R.class, message="正常応答。支払状況ステータス情報を返却する。"),
		@ApiResponse(code=400  ,response=R.class, message="Bad Request of invalid inputs."),
		@ApiResponse(code=500  ,response=R.class, message="A problem occured on the server"),
		@ApiResponse(code=9001 ,response=R.class, message="対象データ存在ません。"),
		@ApiResponse(code=9002 ,response=R.class, message="userNameを指定するか、またはuserRoleId、sqlQuery、recordCountを指定する"),
		@ApiResponse(code=0    ,response=R.class, message="success")})

	@RequestMapping(value = "/paymentStatus", produces = {"application/JSON"}, method = RequestMethod.POST)
	public R readClaimsDetails(@RequestBody SearchCriteriaDTO searchCriteria,@RequestBody String userName,
			@RequestBody String userRoleId,@RequestBody String sqlQuery,@RequestBody Integer recordCount)
	{
		//PaymentStatusSearchDelegateの関数呼び出す
		return R.ok();
	}

	@ApiOperation(value="PDWF Payment Status Search API" ,notes="個人請求詳細情報生成")
	@RequestMapping(value = "/paymentStatus", produces = {"application/JSON"}, method = RequestMethod.PUT)
	public R creatClaimsDetails(@RequestBody SearchCriteriaDTO searchCriteria,@RequestBody String userName,
			@RequestBody String userRoleId,@RequestBody String sqlQuery,@RequestBody Integer recordCount)
	{
		//PaymentStatusSearchDelegateの関数呼び出す
		return R.ok();
	}

	@ApiOperation(value="PDWF Payment Status Search API" ,notes="個人請求詳細情報取得")
	@RequestMapping(value = "/claimsDetails", method = RequestMethod.GET)
	public R readPaymentStatus(@RequestBody SearchCriteriaDTO searchCriteria,@RequestBody String userName,
			@RequestBody String userRoleId,@RequestBody String sqlQuery,@RequestBody Integer recordCount)
	{
		//PaymentStatusSearchDelegateの関数呼び出す
		return R.ok();
	}

	@ApiOperation(value="PDWF Payment Status Search API" ,notes="個人請求詳細情報削除")
	@RequestMapping(value = "/claims", method = RequestMethod.DELETE)
	public R deleteClaims(@RequestBody SearchCriteriaDTO searchCriteria,@RequestBody String userName,
			@RequestBody String userRoleId,@RequestBody String sqlQuery,@RequestBody Integer recordCount)
	{
		//PaymentStatusSearchDelegateの関数呼び出す
		return R.ok();
	}
	@RequestMapping(value = "/api-docs", method = RequestMethod.GET)
    public String index() {
        return "redirect:swagger-ui.html";
    }

}