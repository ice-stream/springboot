package com.tang.core.base;
/**
 * 
* @ClassName: Constant 
* @Description: 系统项目常量
* @author (TangGoooo)  
* @date 2018年1月30日 下午2:39:57 
* @version V1.0
 */
public class Constant {
	
	public static final String BASE_PACKAGE = "com.tang";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity";//Model所在包
    
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.base.Mapper";//Mapper插件基础接口的完全限定名

}
