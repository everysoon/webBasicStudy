package com.example.demo.common;

public class CommonResponseVO {

	private boolean isSuccess;
	private int errCode;
	private String data;

	public CommonResponseVO() {
	}

	public CommonResponseVO(boolean isSuccess, int errCode, String data) {
		this.setSuccess(isSuccess);
		this.setErrCode(errCode);
		this.setData(data);
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setData(Object data) {
		CommonObjectMapper commonObjectMapper = new CommonObjectMapper();
		this.data = commonObjectMapper.getJsonStr(data);
	}

}
