// Description: Java 25 JavaFX Picker of Obj Pane implementation for TokenDef.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbamjavafx;

import java.math.*;
import java.time.*;
import java.text.*;
import java.util.*;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.inz.Inz;
import server.markhome.mcf.v3_1.cflib.javafx.*;
import org.apache.commons.codec.binary.Base64;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.*;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.*;
import server.markhome.mcf.v3_1.cfint.cfintobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbamobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsecjavafx.*;
import server.markhome.mcf.v3_1.cfint.cfintjavafx.*;

/**
 *	CFBamJavaFXTokenDefPickerPane JavaFX Pick Obj Pane implementation
 *	for TokenDef.
 */
public class CFBamJavaFXTokenDefPickerPane
extends CFBorderPane
implements ICFBamJavaFXTokenDefPaneList
{
	public static String S_FormName = "Choose TokenDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTokenDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTokenDefObj> observableListOfTokenDef = null;
	protected TableColumn<ICFBamTokenDefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnId = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnName = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnShortName = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnLabel = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnDescription = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnImplementsPolymorph = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnDbName = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnMaxLen = null;
	protected TableColumn<ICFBamTokenDefObj, $implJavaOptAtomType$> tableColumnInitValue = null;
	protected TableColumn<ICFBamTokenDefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamTokenDefObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXTokenDefChosen invokeWhenChosen = null;
	protected ICFBamScopeObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXTokenDefPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamTokenDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamTokenDefObj> argDataCollection,
		ICFBamJavaFXTokenDefChosen whenChosen )
	{
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argSchema" );
		}
		if( whenChosen == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		invokeWhenChosen = whenChosen;
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFBamTokenDefObj>();
		tableColumnObjKind = new TableColumn<ICFBamTokenDefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamTokenDefObj, String> p ) {
				ICFBamTokenDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int classCode = obj.getClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( Integer.toString(classCode) );
					return( observable );
				}
			}
		});
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,String>,TableCell<ICFBamTokenDefObj,String>>() {
			@Override public TableCell<ICFBamTokenDefObj,String> call(
				TableColumn<ICFBamTokenDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredId();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFDbKeyHash256TableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredName();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalShortName();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalLabel();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalShortDescription();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalDescription();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalDefaultXmlValue();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredIsNullable();
					$implJavaOptAtomType$ wrapped = $implJavaOptAtomType$.valueOf( value );
					ReadOnlyObjectWrapper<$implJavaOptAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaOptAtomType$>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalGenerateId();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredImplementsPolymorph();
					$implJavaOptAtomType$ wrapped = $implJavaOptAtomType$.valueOf( value );
					ReadOnlyObjectWrapper<$implJavaOptAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaOptAtomType$>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamAtomObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalDbName();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnMaxLen = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Max. Length" );
		tableColumnMaxLen.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamTokenDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredMaxLen();
					$implJavaOptAtomType$ wrapped = $implJavaOptAtomType$.valueOf( value );
					ReadOnlyObjectWrapper<$implJavaOptAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaOptAtomType$>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnMaxLen.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFInt32TableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxLen );
		tableColumnInitValue = new TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamTokenDefObj, $implJavaOptAtomType$> p ) {
				ICFBamTokenDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<$implJavaAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaAtomType$>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$>,TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamTokenDefObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamTokenDefObj,$implJavaOptAtomType$> arg)
			{
				return new CFTokenTableCell<ICFBamTokenDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTokenDefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTokenDefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTokenDefObj, ICFBamSchemaDefObj> p ) {
				ICFBamTokenDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamSchemaDefObj ref = obj.getOptionalLookupDefSchema();
					ReadOnlyObjectWrapper<ICFBamSchemaDefObj> observable = new ReadOnlyObjectWrapper<ICFBamSchemaDefObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTokenDefObj,ICFBamSchemaDefObj>,TableCell<ICFBamTokenDefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTokenDefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTokenDefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTokenDefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTokenDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTokenDefObj> observable,
					ICFBamTokenDefObj oldValue,
					ICFBamTokenDefObj newValue )
				{
					setJavaFXFocus( newValue );
					if( buttonChooseSelected != null ) {
						if( newValue != null ) {
							buttonChooseSelected.setDisable( false );
						}
						else {
							buttonChooseSelected.setDisable( true );
						}
					}
				}
			});
		hboxMenu = new CFHBox( 10 );
		buttonCancel = new CFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonCancel );
		buttonChooseNone = new CFButton();
		buttonChooseNone.setMinWidth( 200 );
		buttonChooseNone.setText( "ChooseNone" );
		buttonChooseNone.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					invokeWhenChosen.choseTokenDef( null );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseNone );
		buttonChooseSelected = new CFButton();
		buttonChooseSelected.setMinWidth( 200 );
		buttonChooseSelected.setText( "ChooseSelected" );
		buttonChooseSelected.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					ICFBamTokenDefObj selectedInstance = getJavaFXFocusAsTokenDef();
					invokeWhenChosen.choseTokenDef( selectedInstance );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseSelected );
		if( argFocus != null ) {
			dataTable.getSelectionModel().select( argFocus );
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( hboxMenu );

		setTop( scrollMenu );
		setCenter( dataTable );
		adjustListButtons();
	}

	public ICFFormManager getCFFormManager() {
		return( cfFormManager );
	}

	public void setCFFormManager( ICFFormManager value ) {
		final String S_ProcName = "setCFFormManager";
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		cfFormManager = value;
	}

	public ICFBamJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamTokenDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTokenDefObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamTokenDefObj getJavaFXFocusAsTokenDef() {
		return( (ICFBamTokenDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTokenDef( ICFBamTokenDefObj value ) {
		setJavaFXFocus( value );
	}

	public class TokenDefByQualNameComparator
	implements Comparator<ICFBamTokenDefObj>
	{
		public TokenDefByQualNameComparator() {
		}

		public int compare( ICFBamTokenDefObj lhs, ICFBamTokenDefObj rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsValue = lhs.getObjQualifiedName();
				String rhsValue = rhs.getObjQualifiedName();
				if( lhsValue == null ) {
					if( rhsValue == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsValue == null ) {
					return( 1 );
				}
				else {
					return( lhsValue.compareTo( rhsValue ) );
				}
			}
		}
	}

	protected TokenDefByQualNameComparator compareTokenDefByQualName = new TokenDefByQualNameComparator();

	public Collection<ICFBamTokenDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTokenDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTokenDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTokenDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTokenDef.add( iter.next() );
				}
				observableListOfTokenDef.sort( compareTokenDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTokenDef );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamScopeObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamScopeObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamTokenDefObj selectedObj = getJavaFXFocusAsTokenDef();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( buttonChooseSelected != null ) {
			buttonChooseSelected.setDisable( ! enableState );
		}
		if( buttonChooseNone != null ) {
			buttonChooseNone.setDisable( false );
		}
		if( buttonCancel != null ) {
			buttonCancel.setDisable( false );
		}

	}
}

