package com.github.dandelion.datatables.core.html;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

public class HtmlTableTest {

	private HtmlTable table;

	@Before
	public void createHtmlTable() {
		table = new HtmlTable("tableId", "");
	}

	@Test
	public void should_generate_table_with_id() {
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_one_class() {
		table.addCssClass("aClass");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" class=\"aClass\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_several_classes() {
		table.addCssClass("oneClass");
		table.addCssClass("twoClass");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" class=\"oneClass twoClass\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_one_style() {
		table.addCssStyle("border:1px");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" style=\"border:1px\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_several_styles() {
		table.addCssStyle("border:1px");
		table.addCssStyle("align:center");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" style=\"border:1px;align:center\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_display_none() {
		table.setAppear("block");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" style=\"display:none\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_display_none_and_styles() {
		table.setAppear("block");
		table.addCssStyle("border:1px");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\" style=\"border:1px;display:none\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_without_display_none() {
		table.setAppear("");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_caption() {
		HtmlCaption caption = new HtmlCaption();
		caption.setTitle("title");
		table.setCaption(caption);
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\">" + caption.toHtml() + "<thead></thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_head_rows() {
		HtmlRow header1 = table.addHeaderRow();
		header1.setId("head1");
		HtmlRow header2 = table.addHeaderRow();
		header2.setId("head2");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead>" + header1.toHtml() + header2.toHtml() + "</thead><tbody></tbody></table>");
	}

	@Test
	public void should_generate_table_with_body_rows() {
		HtmlRow body1 = table.addRow("body1");
		HtmlRow body2 = table.addRow();
		body2.setId("body2");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead></thead><tbody>" + body1.toHtml() + body2.toHtml() + "</tbody></table>");
	}

	@Test
	public void should_generate_table_with_body_rows_2() {
		HtmlRow body3 = new HtmlRow("body3");
		HtmlRow body4 = new HtmlRow("body4");
		table.addRows(body3, body4);
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead></thead><tbody>" + body3.toHtml() + body4.toHtml() + "</tbody></table>");
	}

	@Test
	public void should_generate_table_with_foot_rows() {
		HtmlRow foot1 = table.addFooterRow();
		foot1.setId("foot1");
		HtmlRow foot2 = table.addFooterRow();
		foot2.setId("foot2");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\"><thead></thead><tbody></tbody><tfoot>" + foot1.toHtml() + foot2.toHtml() + "</tfoot></table>");
	}

	@Test
	public void should_generate_table_with_outstanding_rows() {
		HtmlRow header1 = table.addHeaderRow();
		header1.setId("head1");
		HtmlRow header2 = table.addHeaderRow();
		header2.setId("head2");
		HtmlRow body1 = table.addRow("body1");
		HtmlRow body2 = table.addRow("body2");
		HtmlRow foot1 = table.addFooterRow();
		foot1.setId("foot1");
		HtmlRow foot2 = table.addFooterRow();
		foot2.setId("foot2");
		assertThat(table.toHtml().toString()).isEqualTo("<table id=\"tableId\">" + //
				"<thead>" + header1.toHtml() + header2.toHtml() + "</thead>" + //
				"<tbody>" + body1.toHtml() + body2.toHtml() + "</tbody>" + //
				"<tfoot>" + foot1.toHtml() + foot2.toHtml() + "</tfoot>" + //
				"</table>");
	}
	
	@Test
	public void should_get_last_rows(){
		HtmlRow header1 = table.addHeaderRow();
		header1.setId("head1");
		HtmlRow header2 = table.addHeaderRow();
		header2.setId("head2");
		table.addRow("body1");
		HtmlRow body2 = table.addRow("body2");
		HtmlRow foot1 = table.addFooterRow();
		foot1.setId("foot1");
		HtmlRow foot2 = table.addFooterRow();
		foot2.setId("foot2");

		assertThat(table.getLastHeaderRow()).isEqualTo(header2);
		assertThat(table.getLastBodyRow()).isEqualTo(body2);
		assertThat(table.getLastFooterRow()).isEqualTo(foot2);
	}
}