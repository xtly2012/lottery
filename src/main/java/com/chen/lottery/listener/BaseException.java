package com.chen.lottery.listener;

public class BaseException extends Exception
{

    private static final long serialVersionUID = 1L;
    
    private String errorId = null;
    
    private String errorMsg = null;
    
    public static String def_error_id = "000000";
    
    public BaseException(String errorId, String errorMsg)
    {
        super(errorMsg);
        this.errorId = errorId;
        this.errorMsg = errorMsg;
    }
    
    public BaseException(String errorMsg)
    {
        super(errorMsg);
        this.errorId = def_error_id;
        this.errorMsg = errorMsg;
    }

    public String getErrorId()
    {
        return errorId;
    }

    public void setErrorId(String errorId)
    {
        this.errorId = errorId;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
    
    @Override
    public String toString()
    {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append(errorId);
        strBuf.append("|");
        strBuf.append(errorMsg);
        
        return strBuf.toString();
    }

}
