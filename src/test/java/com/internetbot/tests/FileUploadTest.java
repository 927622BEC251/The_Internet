package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.FileUploadPage;
import com.internetbot.utils.FileUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileUploadTest extends BaseTest {
    @Test
    public void verifyUploadPageTitleAndFormAreVisibleBeforeInteraction() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        Assert.assertEquals(fileUploadPage.getHeading(), TestDataReader.get("upload.page.heading"));
        Assert.assertTrue(fileUploadPage.isUploadFormVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyFileInputIsVisible() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        Assert.assertTrue(fileUploadPage.isFileInputVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyUploadButtonIsVisible() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        Assert.assertTrue(fileUploadPage.isUploadButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyUploadButtonIsEnabled() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        Assert.assertTrue(fileUploadPage.isUploadButtonEnabled());
        System.out.println("Test Passed");
    }

    @Test
    public void verifySupportedFileCanBeUploaded() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        String fileName = TestDataReader.get("upload.supported.file");
        Path uploadFile = FileUtil.resourcePath("upload-files/" + fileName);
        fileUploadPage.upload(uploadFile);

        Assert.assertEquals(fileUploadPage.getUploadedFileName(), fileName);
        System.out.println("Test Passed");
    }

    @Test
    public void verifyUploadSuccessHeadingAfterUpload() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        String fileName = TestDataReader.get("upload.supported.file");
        Path uploadFile = FileUtil.resourcePath("upload-files/" + fileName);
        fileUploadPage.upload(uploadFile);

        Assert.assertEquals(fileUploadPage.getUploadSuccessHeading(), TestDataReader.get("upload.success.heading"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyUnsupportedFileTypeIsHandledGracefully() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.open();

        String fileName = TestDataReader.get("upload.unsupported.file");
        Path uploadFile = FileUtil.resourcePath("upload-files/" + fileName);
        fileUploadPage.upload(uploadFile);

        Assert.assertEquals(fileUploadPage.getUploadedFileName(), fileName);
        System.out.println("Test Passed");
    }
}
