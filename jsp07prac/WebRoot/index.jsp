<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 基本算术运算 -->
${1 + 2}
<br />
${1 - 2 }

\${1 + 2}		禁用EL表达式	

<br />
${1/-2}
<br />
${0.5/-9}
<br />
${"A" lt "a"}		输出为true
<br />
${"2" lt "20"}			//false
<br />
${"21" > "2"} 			//true
