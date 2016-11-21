package com.crm.report;


public class ClientInteraction {

	public ClientInteraction() {

		// TODO Auto-generated constructor stub
		//		SELECT [Clients].[ClientName]
		//	      ,[Users].[UserName]
		//	     ,[InteractionServiceTypes].[Description]
		//	      ,[InteractionServices].[DateStarted]
		//	      ,[InteractionServices].[DateFinished]
		//	      ,[Aims].[AimDescription]
		//	      ,[InteractionServices].[Status]
		//	      ,[InteractionServices].[Priority]
		//	      ,[InteractionServices].[Contract]
		//	      ,[InteractionServices].[Price]
		//	      ,[InteractionServices].[OtherCost]
		//	      ,[Currency].[Code]
		//	      ,[InteractionServices].[ExchangeRate]
		//	      ,[InteractionServices].[Period]
		//	      ,sum([InteractionServices].[Price]*[InteractionServices].[ExchangeRate]) as PRICEG
		//	      ,sum([InteractionServices].[OtherCost]*[InteractionServices].[ExchangeRate]) as OTHERCOSTG
		//	      ,sum([InteractionServices].[Period]) as TIMEPERIODG
		//	  FROM [InteractionServices]
		//	INNER JOIN [Currency] ON [InteractionServices].[Currency] = [Currency].[ID]
		//	INNER JOIN [Aims] ON [InteractionServices].[AimID] = [Aims].[ID]
		//	INNER JOIN [Users] ON [InteractionServices].[UserModified] = [Users].[ID]
		//	INNER JOIN [ContactClients] ON [InteractionServices].[ClientContactID] = [ContactClients].[ID]
		//	INNER JOIN [Clients] ON [ContactClients].[ClientID] = [Clients].[ID]
		//	INNER JOIN [InteractionServiceTypes] ON  [InteractionServiceTypes].[ID] =  [InteractionServices].[Place]
		//	WHERE
		//	[ContactClients].[ClientID] LIKE $P{clientID}
		//	AND [InteractionServices].[DateStarted] >=  $P{dateStart}
		//	AND [InteractionServices].[DateStarted] <   $P{dateFinish}
		//	AND [InteractionServices].[DateFinished] >= $P{dateStart}
		//	AND [InteractionServices].[DateFinished] <  $P{dateFinish}
		//	AND [InteractionServices].[AimID] LIKE $P{aim}
		//	AND [InteractionServices].[Status] LIKE $P{status}
		//	AND [InteractionServices].[Contract] LIKE $P{iscontract}
		//	AND [InteractionServices].[Place] LIKE $P{place}
		//	AND [InteractionServices].[UserModified] LIKE $P{user}
		//	GROUP BY
		//	[Clients].[ClientName]
		//	      ,[Users].[UserName]
		//		,[InteractionServiceTypes].[Description]
		//	      ,[InteractionServices].[DateStarted]
		//	      ,[InteractionServices].[DateFinished]
		//	      ,[Aims].[AimDescription]
		//	      ,[InteractionServices].[Status]
		//	      ,[InteractionServices].[Priority]
		//	      ,[InteractionServices].[Contract]
		//	      ,[InteractionServices].[Price]
		//	      ,[InteractionServices].[OtherCost]
		//	      ,[Currency].[Code]
		//	      ,[InteractionServices].[ExchangeRate]
		//	      ,[InteractionServices].[Period]
		//	Order by [Clients].[ClientName]


	}
}
