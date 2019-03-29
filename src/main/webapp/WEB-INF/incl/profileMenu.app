<table width="20%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#ff8000">

         <sec:authorize access="isAuthenticated()">
             <tr>
                 <td align="left">
                     <a href="/profil"><s:message code="menu.profil"/></a>
                 </td>
             </tr>
             <tr>
                 <td align="left">
                     <hr>
                 </td>
             </tr>
             <tr>
                 <td align="left">
                     <a href="/kupione"><s:message code="menu.kupione"/></a>
                 </td>
             </tr>
             <tr>
                 <td align="left">
                     <hr>
                 </td>
             </tr>
             <tr>
                 <td align="left">
                     <a href="/profil/sprzedane"><s:message code="menu.sprzedane"/></a>
                 </td>
             </tr>
             <tr>
                 <td align="left">
                     <hr>
                 </td>
             </tr>
         </sec:authorize>

</table>