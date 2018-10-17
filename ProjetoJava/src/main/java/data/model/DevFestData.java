package data.model;

public class DevFestData implements BaseModel {

	private Long id;
	private String filePath;
	private String fileText;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	@Override

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DevFestData that = (DevFestData) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
		return fileText != null ? fileText.equals(that.fileText) : that.fileText == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
		result = 31 * result + (fileText != null ? fileText.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "DevFestData{" +
				"id=" + id +
				", filePath='" + filePath + '\'' +
				", fileText='" + fileText + '\'' +
				'}';
	}
}
