
package com.tangs;
/** 
 * @classname:
 *
 * @description
 *
 * @author 
 * 蓝生 
 * @date：
 * 2011-5-31 下午02:17:31 
 */

import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.ContextBean;
import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.jsp.IteratorStatus;

import com.jrtcms.web.pojo.News;
import com.jrtcms.web.pojo.NewsCategory;
import com.jrtcms.web.service.NewsCategoryService;
import com.jrtcms.web.service.NewsChannelService;
import com.jrtcms.web.service.NewsService;
import com.jrtcms.web.service.PhraseLibraryService;
import com.jrtcms.web.service.impl.PhraseLibraryServiceImpl;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


// Referenced classes of package org.apache.struts2.components:
//            ContextBean

public class NewsListLogic extends ContextBean
{
	class CounterIterator
        implements Iterator
    {

        public boolean hasNext()
        {
            int next = peekNextIndex();
            return step <= 0 ? next >= end : next <= end;
        }

        public Object next()
        {
            if(hasNext())
            {
                int nextIndex = peekNextIndex();
                currentIndex += step;
                return value == null ? Integer.valueOf(nextIndex) : values.get(nextIndex);
            } else
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(currentIndex + step).append(" must be less than or equal to ").append(end).toString());
            }
        }

        private int peekNextIndex()
        {
            return currentIndex + step;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Values cannot be removed from this iterator");
        }

        private int step;
        private int end;
        private int currentIndex;
        private List values;
        final NewsListLogic this$0;

        CounterIterator(Integer begin, Integer end, Integer step, List values)
        {
            this$0 = NewsListLogic.this;
//            super();
            this.end = end.intValue();
            if(step != null)
                this.step = step.intValue();
            currentIndex = begin.intValue() - this.step;
            this.values = values;
        }
    }


    public NewsListLogic(ValueStack stack)
    {
        super(stack);
    }

    public boolean start(Writer writer)
    {
        if(statusAttr != null)
        {
            statusState = new org.apache.struts2.views.jsp.IteratorStatus.StatusState();
            status = new IteratorStatus(statusState);
        }
        if(beginStr != null)
            begin = (Integer)findValue(beginStr, java.lang.Integer.class);
        if(endStr != null)
            end = (Integer)findValue(endStr, java.lang.Integer.class);
        if(stepStr != null)
            step = (Integer)findValue(stepStr, java.lang.Integer.class);
        if(web_idStr != null)
        	web_id = (Integer)findValue(web_idStr, java.lang.Integer.class);
        if(numstr != null)
        	num = (Integer)findValue(numstr, java.lang.Integer.class);
        if(channelIdStr != null)
        	channelId = (Integer)findValue(channelIdStr, java.lang.Integer.class);
        if(categoryIdStr != null)
        	categoryId = (Integer)findValue(categoryIdStr, java.lang.Integer.class);
        if(istopNewStr != null)
        	istopNews = (Integer)findValue(istopNewStr, java.lang.Integer.class);
       
        if(newsIdstr != null)
        	newsId = (Integer)findValue(newsIdstr, java.lang.Integer.class);
        if(channelCn != null)
        	channelCn = (String)findValue(channelCn, java.lang.String.class);
        if( pcodestr != null)
        	pcodeId = (Integer)findValue(pcodestr, java.lang.Integer.class);
        if(categoryExpress != null)
        	categoryExpress = (String)getStack().findValue(categoryExpress, java.lang.String.class, throwExceptionOnELFailure);//(String )findValue(categoryCn,java.lang.String.class);
        if(channelExpress != null)
        	channelExpress = (String)getStack().findValue(channelExpress, java.lang.String.class, throwExceptionOnELFailure);//(String )findValue(categoryCn,java.lang.String.class);
        
       if(categoryCn != null)
    	categoryCn = (String )findValue(categoryCn,java.lang.String.class);
        ValueStack stack = getStack();
        if(value == null && begin == null && end == null)
        	value = "top";
      Object iteratorTarget = findValue(value);// 修改传值
       // Object iteratorTarget = findValue(categoryCn);
        
        NewsChannelService newsChannelService = (NewsChannelService)ApplicationContextUtil.ctx.getBean("newsChannelService");
        NewsService newsService = (NewsService)ApplicationContextUtil.ctx.getBean("newsService");
        NewsCategoryService newsCategoryService = (NewsCategoryService)ApplicationContextUtil.ctx.getBean("newsCategoryService");
        PhraseLibraryService phraseLibrary = (PhraseLibraryService) ApplicationContextUtil.ctx.getBean("phraseLibraryService");
        
        if(web_id == null){
        	web_id = 2;
        }
        if(value != null && "1".equals(value) ){
        	iteratorTarget = newsChannelService.query(new Long(web_id));
        }
        if(value != null && "2".equals(value) ){
//        	iteratorTarget = newsService.queryNewsInNameZhForList("shuangseqiu","zhuangjiatuijian",0,end,new Long(web_id));
        iteratorTarget = newsService.queryNewsListByOnline(new Long(web_id));
        }
        if(value != null && "3".equals(value) ){
//        	iteratorTarget = newsService.queryNewsInNameZhForList("shuangseqiu","zhuangjiatuijian",0,end,new Long(web_id));
        	 if(istopNews==0){
             	
        		 iteratorTarget = newsService.queryNewsForList(channelCn,categoryCn,null,num,new Long(web_id));
             }
        	 else{
        		 iteratorTarget = newsService.queryNewsForList(channelCn,categoryCn,istopNews,num,new Long(web_id));
        	 }
        }
        if(value != null && "4".equals(value) ){
//        	iteratorTarget = newsCategoryService.queryCategoryCn(websiteId,categoryNameCn)("双色球","专家推荐",0,end,new Long(web_id));
        iteratorTarget = newsCategoryService.queryCategoryByCN(new Long(web_id),categoryCn);
        }
        if(value != null && "5".equals(value) ){
  
        iteratorTarget = newsService.queryNewsForList(channelCn,categoryExpress,null,null,new Long(web_id));
        }
        if(value != null && "6".equals(value) ){
        	//分页
        	if(channelId==0){
        	
        		iteratorTarget = newsService.queryNewsListById(null,new Long(categoryId),new Long(num),new Long(end),new Long(web_id));
        	}else{
        		
        		iteratorTarget = newsService.queryNewsListById(new Long(channelId),new Long(categoryId),new Long(num),new Long(end),new Long(web_id));
        	}
        }
        if(value != null && "7".equals(value) ){
        	//新闻
        News news	= newsService.queryNewsByIdForObject(new Long(newsId));
        String  content = news.getContent(); 
        String second = "";
        Map <String ,String>  map = PhraseLibraryServiceImpl.phraseLibrasy;
        if(map.isEmpty()){
        	phraseLibrary.selectAll();
        }
        if(content.indexOf("<a")>-1){
		while(content.length()>0){
			//获取<a 所在的位置
			int index = content.indexOf("<a");	
			//获取<a 之前文字
			String str = content.substring(0, index+1);
			//将剩余的部分赋值给key
			content= content.substring(index+1, content.length());
			if(index==-1){
				str = content;
				content = "";
			}
			//如果str中存在</a,将<a>到</a 之间的文字拼接到aa中，同时将str赋值为</a  之后的文字
			if(str.indexOf("</a>")>-1){
				second+=str.substring(0,str.indexOf("</a>")+1);
			str = str.substring(str.indexOf("</a")+1,str.length());
			}
			for(String keys :map.keySet()){
	   			String regs =map.get(keys).toString();
	   			if(str.indexOf(keys)>-1){
	   				str = str.replaceAll(keys, regs);
	   			}
			}
		   	second+=str;
		}
        }else{
		   		for(String keys :map.keySet()){
		   			String regs =map.get(keys).toString();
		   			if(content.indexOf(keys)>-1){
		   				content = content.replaceAll(keys, regs);
		   			}
				}
		   	second+=content;
        }
        if("".equals(second)){
        	second=news.getContent();
        }
        news.setContent(second);
    	iteratorTarget = news;
        	//iteratorTarget = newsService.queryNewsByIdForObject(new Long(newsId));
        	
        	
        }
        if(value != null && "8".equals(value) ){
//        	iteratorTarget = newsCategoryService.queryCategoryCn(websiteId,categoryNameCn)("双色球","专家推荐",0,end,new Long(web_id));
        iteratorTarget = newsCategoryService.queryCategoryByCN(new Long(web_id),categoryExpress);
        }
        if(value != null && "9".equals(value) ){
        	//查询分类 对象
        	iteratorTarget = newsCategoryService.queryCategoryByCode(new Long(categoryId));
        }
        if(value != null && "10".equals(value) ){
        	//按频道的中文名查询频道
        	iteratorTarget = newsChannelService.queryObjectForChannelCn(channelCn,new Long(web_id));
        }
        if(value != null && "11".equals(value) ){
//        	iteratorTarget = newsService.queryNewsInNameZhForList("shuangseqiu","zhuangjiatuijian",0,end,new Long(web_id));
        	 if(istopNews==0){
             	
        		 iteratorTarget = newsService.queryNewsForList(channelExpress,categoryCn,null,num,new Long(web_id));
             }
        	 else{
        		 iteratorTarget = newsService.queryNewsForList(channelExpress,categoryCn,istopNews,num,new Long(web_id));
        	 }
        }
        //根据分类中文名 和频道的id查询新闻列表
        if(value != null && "12".equals(value) ){
        	 if(channelId==0){
             	
        		 iteratorTarget = newsService.queryNewsListByCnAndId(null, categoryCn, null, num, new Long(web_id));
             }
        	 else{
        		 iteratorTarget = newsService.queryNewsListByCnAndId(new Long(channelId), categoryCn, null, num, new Long(web_id));
        	 }
        }
        //根据分类与频道的中文名查询新闻列表
        if(value != null && "13".equals(value) ){
       
            	 iteratorTarget = newsService.queryNewsListByCodeAll(channelCn, categoryCn, num, new Long(web_id));
           
       }
        //根据频道的id查询频道对象
        if(value != null && "14".equals(value) ){
            
       	 iteratorTarget = newsChannelService.queryObjectForChannelId(new Long(channelId), new Long(web_id));
      
        }
        //查询同一频道下非当前分类的新闻
        if(value != null && "15".equals(value) ){
  
            
          	 iteratorTarget = newsService.queryNewsByNotNowId(new Long(channelId), new Long(categoryId), null, num, new Long(web_id),new Long(pcodeId));
         
     }
        //通过传入的的中文名来查询分类列表
        if(value != null && "16".equals(value) ){
        	  
            
         	 iteratorTarget = newsService.queryNewsForListByCn(channelCn, categoryCn, null, num, new Long(web_id));
        
    }
        if(value != null && "17".equals(value) ){
      	  
            
        	 iteratorTarget = newsService.queryNewsListByIdCn(channelCn,new Long(categoryId),0, num,new Long(web_id));
       
   }
        if(value!=null&&"18".equals(value)){
        	NewsCategory newsCat=new NewsCategory();
        	newsCat.setPcode(new Long(categoryExpress));
        	newsCat.setWebsite_id(new Long(web_id));
        	newsCat.setState(0);
        	iteratorTarget=newsCategoryService.queryCategoryByPcode(newsCat);
        }
        //根据分类的中文名数组查询新闻列表
        if(value != null && "19".equals(value) ){
        	  if(channelId==0){
        		  iteratorTarget = newsService.queryNewsInCategoryNameCnsByChannelIdForMap(new Long(web_id),categoryCn,null,num);
        	  }else{
       	 iteratorTarget = newsService.queryNewsInCategoryNameCnsByChannelIdForMap(new Long(web_id),categoryCn,new Long(channelId),num);
        	  }
      
  }
        //查询当前新闻所属分类下的非当前新闻的新闻
        if(value != null && "20".equals(value) ){
        iteratorTarget = newsService.queryNewsByCategoryIdandNotnowId(new Long (web_id),new Long (categoryId),new Long (newsId), num);
        	
        }
        if(value != null && "21".equals(value) ){
//        	iteratorTarget = newsCategoryService.queryCategoryCn(websiteId,categoryNameCn)("双色球","专家推荐",0,end,new Long(web_id));
        	List list = new ArrayList();
        	list.add(newsCategoryService.queryCategoryByNCn(new Long(web_id),categoryCn));
        iteratorTarget = list;
        }
        iterator = MakeIterator.convert(iteratorTarget);
        if(begin != null)
        {
            if(step == null)
                step = Integer.valueOf(1);
            if(iterator == null)
                iterator = new CounterIterator(begin, end, step, null);
            else
            if(iterator != null)
                if(iteratorTarget.getClass().isArray())
                {
                    Object values[] = (Object[])(Object[])iteratorTarget;
                    if(end == null)
                        end = Integer.valueOf(step.intValue() <= 0 ? 0 : values.length - 1);
                    iterator = new CounterIterator(begin, end, step, Arrays.asList(values));
                } else
                if(iteratorTarget instanceof List)
                {
                    List values = (List)iteratorTarget;
                    if(end == null){
                        end = Integer.valueOf(step.intValue() <= 0 ? 0 : values.size() - 1);
                        }
                    else if(values.size()-1 < end){
                    	end = Integer.valueOf(step.intValue() <= 0 ? 0 : values.size() - 1);
                    }
                    if(values.size()-1 < begin){
                    	begin = Integer.valueOf(step.intValue() <= 0 ? 0 : (values.size() - 1 < 0?0:values.size() - 1));
                    }
                    iterator = new CounterIterator(begin, end, step, values);
                } else
                {
                    //LOG.error("Incorrect use of the iterator tag. When 'begin' is set, 'value' must be an Array or a List, or not set at all. 'begin', 'end' and 'step' will be ignored", new String[0]);
                }
        }
        if(iterator != null && iterator.hasNext())
        {
            Object currentValue = iterator.next();
            stack.push(currentValue);
            String var = getVar();
            if(var != null && currentValue != null)
                putInContext(currentValue);
            if(statusAttr != null)
            {
                statusState.setLast(!iterator.hasNext());
                oldStatus = stack.getContext().get(statusAttr);
                stack.getContext().put(statusAttr, status);
            }
            return true;
        } else
        {
            super.end(writer, "");
            return false;
        }
    }

    public boolean end(Writer writer, String body)
    {
        ValueStack stack = getStack();
        if(iterator != null)
            stack.pop();
        if(iterator != null && iterator.hasNext())
        {
            Object currentValue = iterator.next();
            stack.push(currentValue);
            putInContext(currentValue);
            if(status != null)
            {
                statusState.next();
                statusState.setLast(!iterator.hasNext());
            }
            return true;
        }
        if(status != null)
            if(oldStatus == null)
                stack.getContext().put(statusAttr, null);
            else
                stack.getContext().put(statusAttr, oldStatus);
       /* try {
			//writer.write("sss");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        super.end(writer, "");
        return false;
    }

    public void setStatus(String status)
    {
        statusAttr = status;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public void setBegin(String begin)
    {
        beginStr = begin;
    }

    public void setEnd(String end)
    {
        endStr = end;
    }

    public void setStep(String step)
    {
        stepStr = step;
    }
    public void setWeb_id(String web_id)
    {
    	web_idStr = web_id;
    }
	public void setNum(String  num) {
		numstr = num;
	}
	public void setIstopNews(String istopNews) {
		istopNewStr = istopNews;
	}

	public void setNewsId(String newsId) {
		this.newsIdstr = newsId;
	}

	public void setChannelCn(String channelCn) {
		this.channelCn = channelCn;
	}

	public void setCategoryCn(String categoryCn) {
		this.categoryCn = categoryCn;
	}
	public void setCategoryExpress(String categoryExpress) {
		this.categoryExpress = categoryExpress;
	}
	public void setChannelExpress(String channelExpress) {
		this.channelExpress = channelExpress;
	}
	public void setChannelId(String  channelId) {
		channelIdStr = channelId;
	}
	public void setCategoryId(String  categoryId) {
		categoryIdStr = categoryId;
	}
	public void setPcodeId(String  pcodeId) {
		this.pcodestr = pcodeId;
	}
    private static final Logger LOG = LoggerFactory.getLogger(com.tangs.NewsListLogic.class);
    protected Iterator iterator;
    protected IteratorStatus status;
    protected Object oldStatus;
    protected org.apache.struts2.views.jsp.IteratorStatus.StatusState statusState;
    protected String statusAttr;
    protected String value;
    protected String beginStr;
    protected Integer begin;
    protected String endStr;
    protected Integer end;
    protected String stepStr;
    protected Integer step;
    protected String web_idStr;
    protected Integer web_id;
    protected String numstr;
    protected Integer num;
    protected String newsIdstr;
    protected Integer newsId;
    protected String categoryCn;
    protected String channelCn;
    protected String categoryExpress;
    protected String channelExpress;
    protected String istopNewStr;
    protected int  istopNews;
    protected String channelIdStr;
    protected int  channelId;
    protected String categoryIdStr;
    protected int  categoryId;
    protected int  pcodeId;
    protected String  pcodestr;
	
	
    
    
	
	

}
