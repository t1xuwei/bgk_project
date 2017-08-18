package xuw.bgk.exception;


public class ServiceException extends Exception 
{
    private static final long serialVersionUID = 1L;


    private int errorCode = 0;
    public ServiceException(String errorString) 
    {
        super(errorString);
    }
    
    public ServiceException(int errorCode, String errorString) 
    {
        super(errorString);
        this.errorCode = errorCode;
        
    }
    
    public ServiceException(int errorCode, String errorString, Throwable cause) 
    {
        super(errorString, cause);
        this.errorCode = errorCode;
        
    }

    public int getErrorCode() 
    {
        return this.errorCode;
    }

    public String getErrorString() 
    {
        return this.getMessage();
    }
}