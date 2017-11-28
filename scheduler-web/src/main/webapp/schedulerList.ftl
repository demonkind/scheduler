<#import "/spring.ftl" as spring/>
	  <div class="span-24">
        
        <table   border="0" cellspacing="0" cellpadding="0">
          <thead>
            <tr>
              <th class="span-4">系统名称</th>
              <th class="span-4">任务名称</th>
			   <th class="span-4">cron表达式</th>
			   <th class="span-4">状态</th>
			  <th class="span-4 last">操作</th>
            </tr>
          </thead>
          <tfoot>
          
           <form method="post" action="${rc.contextPath}/schedulerAdd">
   系统名称:<input type="text" name="systemName" id="systemName"/>
    任务名称:<input type="text" name="taskName" id="taskName"/>
     cron表达式     
     :<input type="text" name="cronExp" id="cronExp"/><a href="http://www.cnblogs.com/linjiqin/archive/2013/07/08/3178452.html">示例</a>|
 		 <input type="submit" value="提交定时调度" >
</form>
<hr >
 <form method="get" action="${rc.contextPath}/schedulerList">
   系统名称:<input type="text" name="systemName"/>
    任务名称:<input type="text" name="taskName"/>
   		 <input type="submit" value="查询" >
</form>
<hr >
          </tfoot>
          <tbody>
          <#if schedulerList??>
          <#list schedulerList as sr>
            <tr>
			  <td>${sr.systemName}</td>
              <td>${sr.taskName}</td>
			  <td>${sr.cronExp}</td>
			  
			  <#if sr.status=="on">
			  <td><h4>
			  已开启
			  </h4>
			  <#else>
			   <td class="alt">
			  已关闭
			  </#if>
			  </td>
			  <td>
			    <a href="javascript:modifyScheduler('${sr.systemName}','${sr.taskName}','${sr.cronExp}');"> 更改</a>
			 ||||||||||||||||||
			  
			    <#if sr.status=="on">
			      <a href="${rc.contextPath}/schedulerAdd?systemName=${sr.systemName}&taskName=${sr.taskName}&status=off"> 停止</a></td>
			   <#else>
				    停止
			  </#if>
			
		   </tr>
			</#list>
			</#if>
          </tbody>
        </table>
      </div>
      
  <script src="${rc.contextPath}/scripts/jquery.js" type="text/javascript"></script>
  <script type="text/javascript">
  function modifyScheduler(a,b,c){
	  $("#systemName").attr('value',a);
	  $("#taskName").attr('value',b);
	  $("#cronExp").attr('value',c);
  }
	</script>
