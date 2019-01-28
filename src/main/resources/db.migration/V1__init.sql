CREATE TABLE VoucherTable
(
	[ID] INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	VoucherCode  int  UNIQUE,
	ClientID [INT] FOREIGN KEY REFERENCES ClientTable(ID),
	CampaignID [INT] FOREIGN KEY REFERENCES CampaignTable(ID),
	AmountDiscounted int NULLABLE,
	PercentDiscount int NULLABLE,
	UnitDiscounted int NULLABLE,
	IsDisabled bit default 0,
	VoucherType varchar(10) NO NULL,
	Expirydate date
	)

GO

CREATE TABLE CampaignTable
(
	[ID] INT NOT NULL,
	ClientID [INT] FOREIGN KEY REFERENCES ClientTable(ID),
	CampaignName varchar(20)
	)

GO

CREATE TABLE ClientTable
(
  [ID] INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  CllientID  int unique

	)

GO




CREATE PROCEDURE [dbo].[checkIfVoucherExists](
  @voucherCode varchar(MAX)
)
AS
SELECT * FROM VoucherTable WHERE VoucherCode = @voucherCode
GO




CREATE PROCEDURE [dbo].[uspCreateAmountVoucher]
(
	@voucherCode varchar(MAX),
	@campaignID varchar(50),
	@amountDiscounted int ,
	@voucherType varchar,
	@clientID int,
	@expirydate date
)
AS
BEGIN TRANSACTION

  DECLARE @voucherId int
	SELECT @voucherId = 0

    SELECT @voucherId = ID from VoucherTable where VoucherCode = @voucherCode

	IF(@voucherId > 0)
	    UPDATE VoucherTable SET VoucherCode = @voucherCode, AmountDiscounted = @amountDiscounted,
	      VoucherType = @voucherType,
	    Expirydate = @expirydate, CampaignID = @campaignID, ClientID = @clientID

	ELSE

	BEGIN
        INSERT INTO VoucherTable(VoucherCode, ClientID, CampaignID, AmountDiscounted,
         VoucherType, Expirydate)
        VALUES(@VoucherCode,@clientID, @campaignID, @amountDiscounted, @expirydate)
        SELECT @voucherId = SCOPE_IDENTITY()

        INSERT INTO CampaignTable()

	END

COMMIT
GO