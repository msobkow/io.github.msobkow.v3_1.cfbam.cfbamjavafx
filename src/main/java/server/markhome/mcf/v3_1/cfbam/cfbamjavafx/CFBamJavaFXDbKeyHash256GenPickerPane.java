// Description: Java 25 JavaFX Picker of Obj Pane implementation for DbKeyHash256Gen.

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
 *	CFBamJavaFXDbKeyHash256GenPickerPane JavaFX Pick Obj Pane implementation
 *	for DbKeyHash256Gen.
 */
public class CFBamJavaFXDbKeyHash256GenPickerPane
extends CFBorderPane
implements ICFBamJavaFXDbKeyHash256GenPaneList
{
	public static String S_FormName = "Choose DbKeyHash256Gen";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamDbKeyHash256GenObj> javafxDataCollection = null;
	protected ObservableList<ICFBamDbKeyHash256GenObj> observableListOfDbKeyHash256Gen = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnId = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnName = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnShortName = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnLabel = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnShortDescription = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnDescription = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnIsNullable = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnGenerateId = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnImplementsPolymorph = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnDbName = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnInitValue = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnSlice = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> tableColumnBlockSize = null;
	protected TableColumn<ICFBamDbKeyHash256GenObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamDbKeyHash256GenObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXDbKeyHash256GenChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXDbKeyHash256GenPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamDbKeyHash256GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamDbKeyHash256GenObj> argDataCollection,
		ICFBamJavaFXDbKeyHash256GenChosen whenChosen )
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
		dataTable = new TableView<ICFBamDbKeyHash256GenObj>();
		tableColumnId = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFDbKeyHash256TableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFBoolTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
				ICFBamDbKeyHash256DefObj obj = p.getValue();
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
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFStringTableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnSlice = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "Slice" );
		tableColumnSlice.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
				ICFBamDbKeyHash256GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredSlice();
					$implJavaOptAtomType$ wrapped = $implJavaOptAtomType$.valueOf( value );
					ReadOnlyObjectWrapper<$implJavaOptAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaOptAtomType$>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnSlice.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFInt16TableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSlice );
		tableColumnBlockSize = new TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>( "BlockSize" );
		tableColumnBlockSize.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,ObservableValue<$implJavaOptAtomType$> >() {
			public ObservableValue<$implJavaOptAtomType$> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, $implJavaOptAtomType$> p ) {
				ICFBamDbKeyHash256GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					$implJavaAtomType$ value = obj.getRequiredBlockSize();
					$implJavaOptAtomType$ wrapped = $implJavaOptAtomType$.valueOf( value );
					ReadOnlyObjectWrapper<$implJavaOptAtomType$> observable = new ReadOnlyObjectWrapper<$implJavaOptAtomType$>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnBlockSize.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>,TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> call(
				TableColumn<ICFBamDbKeyHash256GenObj,$implJavaOptAtomType$> arg)
			{
				return new CFInt32TableCell<ICFBamDbKeyHash256GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnBlockSize );
		tableColumnLookupDefSchema = new TableColumn<ICFBamDbKeyHash256GenObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamDbKeyHash256GenObj, ICFBamSchemaDefObj> p ) {
				ICFBamDbKeyHash256GenObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj>,TableCell<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDbKeyHash256GenObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamDbKeyHash256GenObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamDbKeyHash256GenObj> observable,
					ICFBamDbKeyHash256GenObj oldValue,
					ICFBamDbKeyHash256GenObj newValue )
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
					invokeWhenChosen.choseDbKeyHash256Gen( null );
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
					ICFBamDbKeyHash256GenObj selectedInstance = getJavaFXFocusAsDbKeyHash256Gen();
					invokeWhenChosen.choseDbKeyHash256Gen( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamDbKeyHash256GenObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDbKeyHash256GenObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamDbKeyHash256GenObj getJavaFXFocusAsDbKeyHash256Gen() {
		return( (ICFBamDbKeyHash256GenObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsDbKeyHash256Gen( ICFBamDbKeyHash256GenObj value ) {
		setJavaFXFocus( value );
	}

	public class DbKeyHash256GenByQualNameComparator
	implements Comparator<ICFBamDbKeyHash256GenObj>
	{
		public DbKeyHash256GenByQualNameComparator() {
		}

		public int compare( ICFBamDbKeyHash256GenObj lhs, ICFBamDbKeyHash256GenObj rhs ) {
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

	protected DbKeyHash256GenByQualNameComparator compareDbKeyHash256GenByQualName = new DbKeyHash256GenByQualNameComparator();

	public Collection<ICFBamDbKeyHash256GenObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamDbKeyHash256GenObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfDbKeyHash256Gen = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamDbKeyHash256GenObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfDbKeyHash256Gen.add( iter.next() );
				}
				observableListOfDbKeyHash256Gen.sort( compareDbKeyHash256GenByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfDbKeyHash256Gen );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamSchemaDefObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamDbKeyHash256GenObj selectedObj = getJavaFXFocusAsDbKeyHash256Gen();
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

