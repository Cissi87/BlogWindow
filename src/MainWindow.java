import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import blog.Author;
import blog.BlogPosts;
import blog.Category;
import blog.Post;


public class MainWindow {
	private static Text text_content;
	private static Text text_title;
	private static Text text_author;
	private static Text text_category;
	private static List list;
	private static BlogPosts blogPosts = new BlogPosts();
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 255, 255));
		shell.setSize(553, 657);
		shell.setText("SWT Application");
		
		Label lblNewBlogPost = new Label(shell, SWT.NONE);
		lblNewBlogPost.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblNewBlogPost.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblNewBlogPost.setFont(SWTResourceManager.getFont("Tahoma", 16, SWT.NORMAL));
		lblNewBlogPost.setBounds(46, 29, 147, 25);
		lblNewBlogPost.setText("New Blog Post");
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblTitle.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblTitle.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		lblTitle.setBounds(46, 63, 55, 20);
		lblTitle.setText("Title:");
		
		text_title = new Text(shell, SWT.BORDER);
		text_title.setBackground(SWTResourceManager.getColor(253, 245, 230));
		text_title.setForeground(SWTResourceManager.getColor(119, 136, 153));
		text_title.setBounds(124, 63, 331, 20);
		
		Label lblPost = new Label(shell, SWT.NONE);
		lblPost.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblPost.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblPost.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		lblPost.setBounds(46, 89, 72, 20);
		lblPost.setText("Content:");
		
		text_content = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_content.setForeground(SWTResourceManager.getColor(119, 136, 153));
		text_content.setBackground(SWTResourceManager.getColor(253, 245, 230));
		text_content.setBounds(124, 89, 331, 121);
		
		Label lblCategory = new Label(shell, SWT.NONE);
		lblCategory.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblCategory.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblCategory.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		lblCategory.setBounds(46, 216, 68, 20);
		lblCategory.setText("Category:");
		
		text_category = new Text(shell, SWT.BORDER);
		text_category.setForeground(SWTResourceManager.getColor(119, 136, 153));
		text_category.setBackground(SWTResourceManager.getColor(253, 245, 230));
		text_category.setBounds(124, 216, 331, 20);
		
		Label lblAuthor = new Label(shell, SWT.NONE);
		lblAuthor.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblAuthor.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblAuthor.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		lblAuthor.setBounds(46, 242, 55, 21);
		lblAuthor.setText("Author:");
		
		text_author = new Text(shell, SWT.BORDER);
		text_author.setForeground(SWTResourceManager.getColor(119, 136, 153));
		text_author.setBackground(SWTResourceManager.getColor(253, 245, 230));
		text_author.setBounds(124, 242, 331, 21);
		
		// -------- BUTTON - POST -----------
		Button btnPost = new Button(shell, SWT.NONE);
		btnPost.setForeground(SWTResourceManager.getColor(0, 0, 0));
		btnPost.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Post post = new Post();
				Author auth = new Author();
				Category cat = new Category();
				
				post.setTitle(text_title.getText()); //h�mtar text ur titel rutan och l�gger in i ny instans av Post - title
				post.setContent(text_content.getText()); //h�mtar text ur content rutan och l�gger in i ny instans av Post - content
				auth.setName(text_author.getText()); //h�mtar texten ur author rutan och l�gger in i ny instans av author - name
				cat.setCategory(text_category.getText()); //h�mtar texten ur category rutan och l�gger in i ny instans av category - category
				post.authorList.add(auth); //l�gg till auth i post - authorList
				post.categoryList.add(cat); //l�gg till cat i post - categoryList
				
				blogPosts.items.add(post); //ny instans av BlogPosts, l�gger till post i listan Items fr�n blogPosts
				list.add(post.getTitle()); //l�gger till post.title i listan i f�nstret
				
				
				text_title.getText();
				post.setContent(text_content.getText());
				auth.setName(text_author.getText()); 
				cat.setCategory(text_category.getText());
			}
		});
		btnPost.setBounds(387, 269, 68, 23);
		btnPost.setText("Post");
		
		// ---------- LIST - SELECTION ------------
		list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		list.setForeground(SWTResourceManager.getColor(119, 136, 153));
		list.setBackground(SWTResourceManager.getColor(253, 245, 230));
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( list.getSelectionIndex() < 0 ){ //om man klickar n�gonstans i listan d�r det inte finns n�got inl�gg
					System.out.println("too low");
				}
				else {
					Post post = blogPosts.items.get(list.getSelectionIndex()); //h�mtar ut ett item ur listan i BlogPosts baserat
						//p� vilken rad i listan som �r vald (selectionIndex), och l�gger i ny instans av Post
					text_title.setText(post.getTitle()); //s�tter texten fr�n post.title i rutan f�r title  
					text_content.setText(post.getContent()); //s�tter texten fr�n post.content i rutan f�r content
					
					for (int i = 0; i < post.authorList.size(); i++) {
						String auth = post.authorList.get(i).getName(); 
						text_author.setText(auth); //s�tter texten fr�n post.authorList i rutan f�r author
					}
					for (int i = 0; i < post.categoryList.size(); i++) {
						String cat = post.categoryList.get(i).getCategory();
						text_category.setText(cat); //s�tter texten fr�n post.categoryList i rutan f�r category
					}
					
				}
			}
		});
		//this is a comment
		list.setBounds(124, 324, 331, 82);
		
		Label lblBlogPosts = new Label(shell, SWT.NONE);
		lblBlogPosts.setText("Blog Posts");
		lblBlogPosts.setForeground(SWTResourceManager.getColor(119, 136, 153));
		lblBlogPosts.setFont(SWTResourceManager.getFont("Tahoma", 16, SWT.NORMAL));
		lblBlogPosts.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblBlogPosts.setBounds(46, 293, 147, 25);
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public List getList() {
		return list;
	}
}
