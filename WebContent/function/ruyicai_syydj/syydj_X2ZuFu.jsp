<%@ page contentType="text/html; charset=utf-8"%>
<div class="ChannelBuyTip">玩法提示：任意2个号码组成1注有效注。1/55的中奖机会，奖金65元。</div>
<div class="space10">&nbsp;</div>
<div class="touzhuqi">
			<div class="redselect_left_3dp" style="margin:0px 0px 0px 15px; display:inline;"><span class="redselect_left_zi">选择号码</span>
					<span class="redselect_left_zi1">遗　　漏</span>
		   </div>
		<div class="redselect_mid_3dp">
				<div class="redselect_mid_ball3dp" style="height:57px;">
					<ul>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_1"  class="ball_num">01</li>
				        <li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_2"  class="ball_num">02</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_3"  class="ball_num">03</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_4"  class="ball_num">04</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_5"  class="ball_num">05</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_6"  class="ball_num">06</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_7"  class="ball_num">07</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_8"  class="ball_num">08</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_9"  class="ball_num">09</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_10" class="ball_num">10</li>
						<li onmouseout="getColor(this,'ball_num_f','ball_num')" onmouseover="getColor(this,'ball_num','ball_num_f')" onclick="SelectBallZ2(this);" id="td_Z2_1_11" class="ball_num">11</li>
						<li onclick="QuickSelectZ2ZhiF(this);" class="ball_numb1" id="td_Z2_1_Q">全</li>
						<li onclick="QuickSelectZ2ZhiF(this);" class="ball_numb" id="td_Z2_1_D">大</li>
						<li onclick="QuickSelectZ2ZhiF(this);" class="ball_numb" id="td_Z2_1_X">小</li>
						<li onclick="QuickSelectZ2ZhiF(this);" class="ball_numb" id="td_Z2_1_J">奇</li>
						<li onclick="QuickSelectZ2ZhiF(this);" class="ball_numb" id="td_Z2_1_O">偶</li>
						<li onclick="ClearAll('Z2',1);" class="ball_numb" id="td_Z2_1_C">清</li>
					</ul>
					<dl id="Q2Z_miss" class="omit">
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
						<dd>0</dd>
					</dl>
		     </div>
		</div>
		<div style="float: left; width: 560px; margin: 10px 0px 0px 90px; display:inline;" class="ChannelBuyBox ChannelBuyBoxBottomYellow"> <i>【 您选择了 <b id="Z2zhi_zhu">0</b> 注，共 <b id="Z2zhi_yuan">0</b> 元。】<a onclick="ClearAll('Z2',1);" class="light">清空选号区</a></i><span>&nbsp;</span> </div>
		<div class="ChannelBuyAddBasket">
			  <div class="AddBasketCenter">
						<div class="ChannelBuyAddButton">
							<img src="/images/addbtn.gif" id="btn_Z2_Add" onclick="btn_2_AddClickZ2zuxuan();jisuanZhuihao();">
						</div>
						<div class="space20l">&nbsp;</div>
						<div class="ChannelBuySelectButton">
							 <select id="jixuan_Rand_Z2zuxuan" name="select">
							 	<option value="1">1</option>
							 	<option value="2">2</option>
							 	<option value="5" selected="selected">5</option>
							 	<option  value="10">10</option>
							 	<option value="20">20</option>
							 </select>
							 <span onclick="btn_2_RandManyClick($(&quot;#jixuan_Rand_Z2zuxuan&quot;).val());jisuanZhuihao();" class="light">&nbsp;</span>
						</div>
				</div>
		</div>
 </div>