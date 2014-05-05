<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>   
	<!-- CSS
    ================================================== -->
   <link rel="stylesheet" href="assets/css/default.css">
	<link rel="stylesheet" href="assets/css/layout.css">
   <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

   <!-- Header
   ================================================== -->
   <header id="home">     

      <div class="row banner">
         <div class="banner-text">
            <h2 class="responsive-headline">Lion Air Payment Gateway</h2>
            <h3>
            <form name="submitPaymentConfirmation" id="submitPaymentConfirmation" action="submitPaymentConfirmation.do">               
             	
             	<display:table id="obj" name="form.unpaidTransactionList"  style="width:100%" class ="datagrid sortable resizeable zebra">
             			<display:caption></display:caption>						
						<%-- <display:column property="transactionId" title="Transaction ID"/> --%>
						<display:column property="msisdn" title="MSISDN"/>
						<display:column property="paymentCode" title="Payment Code"/>
						<display:column property="flag" title="Flag"/>
						<display:column  title="">  
							<a class="button" href="#" id="${obj.transactionId}" onClick="submitform('${obj.transactionId}');" >Confirm</a>  
						</display:column>														
				</display:table>
            	   
   			
   			<input type="hidden" id="selectedTrx" name="selectedTrx"/>   			
			</form>
            </h3>
            
            
         </div>
      </div>

      

   </header> <!-- Header End -->      

</body>
<script type="text/javascript">
function submitform(trxId)
{
  document.getElementById("selectedTrx").value = trxId;	
  document.submitPaymentConfirmation.submit();
}
</script>