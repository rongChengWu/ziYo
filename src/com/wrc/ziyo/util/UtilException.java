/*    */package com.wrc.ziyo.util;

/*    */
/*    */public class UtilException extends Exception
/*    */{
	/*    */private static final long serialVersionUID = 1L;
	/* 15 */private ExcCode excCode = null;
	/*    */
	/* 24 */public static final String[] excMessage = {
			/* 25 */"内部异常",
			/* 26 */"您没有执行本操作的权限",
			/* 27 */"提供的数据为空或不合法",
			/* 28 */"数据处理异常",
			/* 29 */"您可能还没有登录本系统，或者已经超时，请 <p><a href='/ziYo' target='_parent'> 重新登录</a></p>" };

	/*    */
	/*    */public static String getExcMessage(ExcCode excCode)
	/*    */{
		/* 33 */return excMessage[excCode.ordinal()];
		/*    */}

	/*    */public String getExcMessage() {
		/* 36 */return excMessage[this.excCode.ordinal()];
		/*    */}

	/*    */public UtilException() {
		/* 39 */super(getExcMessage(ExcCode.AppError));
		/* 40 */this.excCode = ExcCode.AppError;
		/*    */}

	/*    */public UtilException(ExcCode excCode) {
		/* 43 */super(getExcMessage(excCode));
		/* 44 */this.excCode = excCode;
		/*    */}

	/*    */
	/*    */public UtilException(ExcCode excCode, Throwable throwable) {
		/* 48 */super(getExcMessage(excCode), throwable);
		/* 49 */setStackTrace(throwable.getStackTrace());
		/* 50 */this.excCode = excCode;
		/*    */}

	/*    */
	/*    */public UtilException(Throwable throwable)
	/*    */{
		/* 55 */super(
				getExcMessage(throwable.getClass() == UtilException.class ?
				/* 55 */((UtilException) throwable).excCode : ExcCode.AppError),
				throwable);
		/* 56 */setStackTrace(throwable.getStackTrace());
		/* 57 */if (throwable.getClass() == UtilException.class)
			/* 58 */this.excCode = ((UtilException) throwable).excCode;
		/*    */else
			/* 60 */this.excCode = ExcCode.AppError;
		/*    */}

	/*    */
	/*    */public static enum ExcCode
	/*    */{
		/* 17 */AppError,
		/* 18 */InvalidRights,
		/* 19 */IllegalData,
		/* 20 */DataProcessing,
		/* 21 */Unlogined;
		/*    */
	}
	/*    */
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.util.UtilException JD-Core Version: 0.6.0
 */