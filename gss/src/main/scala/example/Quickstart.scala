package example
import java.io.{ File, IOException, InputStreamReader }
import java.util
import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.{ GoogleAuthorizationCodeFlow, GoogleClientSecrets }
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.sheets.v4.{ Sheets, SheetsScopes }
import scala.collection.JavaConverters._

object Quickstart {

  private val applicationName = "Google Sheets API Scala Quickstart"
  private val dataStoreDir = new File(System.getProperty("user.home"), ".credentials/sheets.googleapis.com-scala-quickstart")
  private val dataStoreFactory = new FileDataStoreFactory(dataStoreDir)
  private val jsonFactory = JacksonFactory.getDefaultInstance
  private val httpTransport = GoogleNetHttpTransport.newTrustedTransport()

  private val scopes = util.Arrays.asList(SheetsScopes.SPREADSHEETS)

  @throws[IOException]
  private def authorize: Credential = {
    val in = classOf[Nothing] getResourceAsStream "/client_secret.json"
    val clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in))
    val flow = new GoogleAuthorizationCodeFlow.Builder(
      httpTransport,
      jsonFactory,
      clientSecrets,
      scopes)
      .setDataStoreFactory(dataStoreFactory)
      .setAccessType("offline")
      .build

    new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver).authorize("user")
  }

  @throws[IOException]
  private def getSheetsService: Sheets = {
    val credential = authorize
    new Sheets.Builder(httpTransport, jsonFactory, credential).setApplicationName(applicationName).build
  }

  @throws[IOException]
  def main(args: Array[String]): Unit = {
    val service = getSheetsService
    val spreadsheetId: String = "15EKEBb0Zyx0FRdf0dCcPy_FuMqCU0XWnLnhIa_R6r5o"
    val range = "シート1!A1:E"
    val response = service.spreadsheets.values.get(spreadsheetId, range).execute
    val values = response.getValues
    for {
      row <- values.asScala
      columnA = row.get(0)
      columnB = row.get(1)
      columnC = row.get(2)
      columnD = row.get(3)
      columnE = row.get(4)
    } yield {
      println(s"$columnA $columnB $columnC $columnD $columnE")
    }
  }
}
